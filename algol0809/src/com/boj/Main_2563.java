package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {
    final static int SIZE = 100;
    final static int MINISIZE = 10;
    static int n;
    static int[][] canvas = new int[SIZE][SIZE];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x+MINISIZE; j++) {
                for (int k = y; k < y+MINISIZE; k++) {
                    canvas[j][k] = 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
//                result = Math.max(dfs(i, j), result);
                if(canvas[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }
    static int dfs(int y, int x){
        if(canvas[y][x] == 0) return 0;

        canvas[y][x] = 0;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && SIZE > nx &&  0 <= ny && SIZE > ny && canvas[ny][nx] == 1){
                cnt += 1 + dfs(ny, nx);
            }
        }

        return cnt;
    }
}
