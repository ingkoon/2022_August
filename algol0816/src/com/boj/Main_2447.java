package com.boj;

import java.util.Scanner;

public class Main_2447 {
    static int[][] star;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        star = new int[n][n];

        //구현
        star(0,0,n);

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(star[i][j] == 1 ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void star(int r, int c, int n) {
        if(n == 3){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == 1 && j ==1) continue;
                    star[r + i][c + j] = 1;
                }
            }
        }
        else{
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i ==1&& j ==1) continue;
                    star(r + i * n/3, c + j* n/3, n/3);
                }
            }
        }
    }
}
