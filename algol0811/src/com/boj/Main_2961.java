package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
    static int[][] p;
    static int n;
    static int count;
    static long min;


    public static void main(String[] args) throws IOException {
        min = Long.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        subSet(0, 1L, 0L);
        System.out.println(min);
    }

    //대칭적인 구조 -> 백트래킹
    private static void subSet(int cnt, long tbitter, long tsour) {
        if(cnt == n){
            if(tsour>0){
                min = Math.min(min, Math.abs(tsour - tbitter));
            }
            return;
        }
        subSet(cnt+1,  tbitter * p[cnt][0], tsour+ p[cnt][1]);
        subSet(cnt+1, tbitter, tsour );
    }
}
