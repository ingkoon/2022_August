package com.boj;

import java.util.Scanner;

public class Main_10971 {
    static int n;
    static int[][] cities;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cities = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cities[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(cities[i][0], i, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int start, int loc, int cnt) {
        if(check()){
            if(cities[loc][start]!=0) {
                result = Math.min(result, cnt + cities[loc][start]);
            }
            return;
        }
        for (int i = 1; i < n; i++) {
            if(cities[loc][i] == 0 || visited[i]) continue;
            visited[i] = true;
            dfs(start, i, cnt+cities[loc][i]);
            visited[i] = false;
        }
    }

    private static boolean check() {
        for(boolean b :  visited){
            if(!b) return false;
        }
        return true;
    }
}
