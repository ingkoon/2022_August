package com.boj;

import java.util.Scanner;

public class Main_14889 {

    static int n;
    static int[][] ability;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ability[i][j] = sc.nextInt();
            }
        }
        npr(0,0);
    }

    private static void npr(int cnt, int start) {
        if(cnt == n/2){
            return;
        }

        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            npr(cnt+1, start+1);
            visited[i] = false;


        }
    }
}
