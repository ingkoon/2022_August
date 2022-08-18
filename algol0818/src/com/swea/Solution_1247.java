package com.swea;

import java.util.Scanner;

public class Solution_1247 {

    static int T;
    static int n;
    static int[][] map;
    static int[] home;

    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            result = Integer.MAX_VALUE;
            int[] company = {sc.nextInt(), sc.nextInt()};
            home = new int[]{sc.nextInt(), sc.nextInt()};

            map = new int[n][2];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
            }

            npr(0, company, 0);
            System.out.printf("#%d %d\n",t ,result);
        }
    }

    private static void npr(int cnt, int[] loc, int tmp) {
        if(cnt == n){
            tmp += Math.abs(loc[0] - home[0]) + Math.abs(loc[1] - home[1]);
            result = Math.min(tmp, result);
            return;
        }

        int tmpVal = tmp;
        int[] tmpLoc = loc;
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            tmp += Math.abs(loc[0] - map[i][0]) + Math.abs(loc[1] - map[i][1]);
            loc = map[i];
            npr(cnt+1, loc, tmp);
            visited[i] = false;
            tmp = tmpVal;
            loc = tmpLoc;
        }
    }
}
