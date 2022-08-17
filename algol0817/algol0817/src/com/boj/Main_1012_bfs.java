package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1012_bfs {
    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
    static int T;
    static int m, n, k;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] ground;

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
            ground = new int[m][n];

            k = sc.nextInt();
            result = 0;

            for (int i = 0; i < k; i++) {
                ground[sc.nextInt()][sc.nextInt()] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(ground[i][j] == 1)
                        bfs(i, j);
                }
            }
            System.out.println(result);
        }
    }

    static void bfs(int r, int c){
        result++;
        Queue<Loc> queue= new LinkedList<>();
        queue.offer(new Loc(r,c));
        while(!queue.isEmpty()){
            Loc l = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = l.r + dr[i];
                int nc = l.c + dc[i];
                if(isChecked(nr, nc) && ground[nr][nc] == 1){
                    ground[nr][nc] = 0;
                    queue.offer(new Loc(nr, nc));
                }
            }
        }
    }

    static boolean isChecked(int r, int c){
        return( 0<=r &&r< m && 0<= c && c < n);
    }
}
