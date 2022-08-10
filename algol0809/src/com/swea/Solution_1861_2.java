package com.swea;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution_1861_2 {
    static  int T, n, start, result;

    static int[][] rooms;
    static int[][] backUp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/com/swea/input_1861.txt"));
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();

            rooms = new int[n][n];
            backUp = new int[n][n];
            start = 0;
            result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = sc.nextInt();
                    rooms[i][j] = num;
                    backUp[i][j] = num;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int tmp = dfs(i, j) + 1;
                    if(tmp >= result){
                        if(tmp == result & start < rooms[i][j])
                            continue;
                        result = tmp;
                        start = rooms[i][j];
                    }
                }
            }
            System.out.printf("#%d %d %d\n", t, start, result);
        }
    }

    private static int dfs(int y, int x) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >=0 && ny < n && (rooms[ny][nx] == rooms[y][x] + 1)) {
                cnt++;
                cnt += dfs(ny, nx);
            }
        }
        return cnt;
    }
}
