package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8382 {
    static int T;
    static int r1, r2, c1,c2;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1}; // 상 좌 하 우 even odd
    static int val;
    static int[][][] visited; // 핵심 -> 딜레마: 갈수있는 방법
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            r1 = sc.nextInt()+100;
            r2 = sc.nextInt()+100;
            c1 = sc.nextInt()+100;
            c2 = sc.nextInt()+100;

            visited = new int [201][201][2];
            val = -1;
            bfs();
            System.out.printf("#%d %d\n", t, val);
        }
    }

    private static void bfs() {
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[] {r1, c1, 0,0}); // 좌표 거리 방향
        queue.offer(new int[] {r1, c1, 0,1}); // 좌표 거리 방향
        visited[r1][c1][0] = 1; // 위아래로 움직였음
        visited[r1][c1][1] = 1; // 양옆으로 움직였음

        while (!queue.isEmpty()){
            int[] cur= queue.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            int dir = cur[3];
            if(r == r2 && c == c2){
                val = cnt;
                return;
            }
            for (int d = 0; d < 4; d+=2) {
                int s = (dir+d)%4; // 2+0+1, 2+1+1
                int u = (dir+d)%2; // 2+0+1, 2+1+1
                int nr = r + dr[s]; // 방향이 바뀐다.
                int nc = c + dc[s];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc][u] == 0){
                    queue.offer(new int[] {nr, nc, cnt+1,s}); // 좌표 거리 방향
                    visited[nr][nc][u] = 1; // 양옆으로 움직였음
                }
            }
        }


    }

    private static boolean check(int nr, int nc) {
        return (0<=nr && nr<201 && 0 <=nc && nc <201);

    }
}
