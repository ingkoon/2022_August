package com.boj;

import java.util.Scanner;

public class Main_1010v2 {
    static long[][] memo = new long[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // nCm의 경우의 수 구하기
            // factorial 활용
            System.out.println(nCr(M, N));
        }
    }

    static long nCr(int n, int r) {
        //탐색이 진행 된 위치이다.
        if(memo[n][r] > 0){
            return memo[n][r];
        }
        //해당 탐색이 끝난 위치일 경우 1반환
       if(n == r || r == 0){
           return memo[n][r] = 1;
       }

       return memo[n][r] = nCr( n-1, r-1) + nCr(n-1, r);
    }
}