package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17406 {
    static int n, m, k;
    static int r, c ,s;
    static int[][] arr;
    static int[][] calc;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                calc[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(new boolean[k], new LinkedList<Integer>());
    }
    static void permutation(boolean[] visited, LinkedList<Integer> perm) {
        if(perm.size() == k) {
            int[][] tmpMap = copyMap();

            for (Integer idx : perm) {
                int r = calc[idx][0];
                int c = calc[idx][1];
                int s = calc[idx][2];

                calcNext(r, c, s, tmpMap);
            }
            result = Math.min(result, calcArr(tmpMap));
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(i);

                permutation(visited, perm);

                visited[i] = false;
                perm.removeLast();
            }
        }
    }
    static void calcNext(int r, int c, int s, int[][] tmpMap) {

        for (int i = 0; i < s; i++) {
            // 가장 왼쪽 윗 칸 좌표
            int x1 = r - s + i;
            int y1 = c - s + i;
            // 가장 오른쪽 아랫 칸 좌표
            int x2 = r + s - i;
            int y2 = c + s - i;

            rotate(tmpMap, x1, y1, x2, y2);
        }
    }
    private static void rotate(int[][] tmpMap, int x1, int y1, int x2, int y2) {
        int temp, pastTemp;

        temp = tmpMap[x1][y2];
        for (int y = y2; y > y1; y--) {
            tmpMap[x1][y] = tmpMap[x1][y - 1];
        }

        pastTemp = temp;
        temp = tmpMap[x2][y2];

        for (int x = x2; x > x1; x--) {
            if (x - 1 == x1) {
                tmpMap[x][y2] = pastTemp;
                continue;
            }
            tmpMap[x][y2] = tmpMap[x - 1][y2];
        }

        pastTemp = temp;
        temp = tmpMap[x2][y1];

        for (int y = y1; y < y2; y++) {
            if (y + 1 == y2) {
                tmpMap[x2][y] = pastTemp;
                continue;
            }

            tmpMap[x2][y] = tmpMap[x2][y + 1];
        }

        // 진행 4 : 왼쪽변
        pastTemp = temp;

        for (int x = x1; x < x2; x++) {
            if (x + 1 == x2) {
                tmpMap[x][y1] = pastTemp;
                continue;
            }

            tmpMap[x][y1] = tmpMap[x + 1][y1];
        }

        return;
    }

    static int calcArr(int[][] nMap) {
        int[] rowSum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += nMap[i][j];
            }
        }

        Arrays.sort(rowSum);

        return rowSum[0];
    }


    static int[][] copyMap() {
        int[][] tmpMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, tmpMap[i], 0, m);
        }

        return tmpMap;
    }
}


