package com.swea;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution_1861 {
    static  int T, n, start, result;

    static int[][] rooms;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/com/swea/input_1861.txt"));
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();

            rooms = new int[n][n];
            visited = new boolean[n][n];
            start = 0;
            result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rooms[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, 0);
                }
            }
            System.out.printf("#%d %d %d\n", t, start, result);
        }
    }

    private static void dfs(int y, int x,  int cnt) {
        int returnCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >= n  || ny < 0 || ny >= n) {
                returnCnt++;
                continue;
            }
            if(rooms[ny][nx] != rooms[y][x]+1) returnCnt += 1;
        }
        if (returnCnt == 4 && result < cnt) {
            result = cnt;
            start = rooms[y][x];
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >= n  || ny < 0 || ny >= n)
                continue;
            if(rooms[ny][nx] == (rooms[y][x] + 1) && !visited[ny][nx])
                dfs(ny, nx, cnt+ 1);
        }
    }
}
