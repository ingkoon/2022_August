package com.boj;

import java.util.Scanner;

public class Main_1012_dfs {

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
                    if(ground[i][j] == 1) {
                        result++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void dfs(int r, int c){
        ground[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isChecked(nr, nc) && ground[nr][nc] == 1){
                dfs(nr,nc);
            }
        }
    }

    static boolean isChecked(int r, int c){
        return( 0<=r &&r< m && 0<= c && c < n);
    }
}
