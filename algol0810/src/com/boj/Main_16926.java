package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
    static int n, m, r;
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(n, m)/2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < cnt; j++) {
                int x = j;
                int y = j;

                int tmp = arr[y][x];

                int d = 0;
                while (d<4){
                    int nx = x + dc[d];
                    int ny = y + dr[d];
                    if(check(nx, ny, j)){
                        arr[y][x] = arr[ny][nx];
                        x = nx;
                        y = ny;
                    }
                    else d++;
                }
                arr[j+1][j] = tmp;
            }
        }

        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static boolean check(int nx, int ny, int tmp) {
        return (nx >= tmp && nx < m - tmp && ny >= tmp && ny < n - tmp);
    }
}
