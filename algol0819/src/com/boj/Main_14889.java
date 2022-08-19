package com.boj;

import java.util.Scanner;

public class Main_14889 {

    static int n;
    static int[][] ability;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ability[i][j] = sc.nextInt();
            }
        }


    }
}
