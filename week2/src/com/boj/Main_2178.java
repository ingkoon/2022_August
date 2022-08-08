package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
    static int n, m;
    static int[][] maze;
    static int[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = tmp[j];
            }
        }
        bfs();
        System.out.println(maze[n-1][m-1]);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        visited[0][0] = 1;
        queue.offer(new int[] {0,0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == n -1 && cur[1] == m-1){
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(!check(nx, ny)) continue;
                if(maze[ny][nx] == 1 && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[cur[1]][cur[0]] + 1;
                    queue.offer(new int[] {ny, nx});

                }

            }
        }
    }
    private static boolean check(int nx, int ny) {
        return nx>=0 && nx<m && ny >=0 && ny >n;
    }
}
