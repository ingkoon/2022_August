package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    static int n, m;
    static int[] woods;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        woods = new int[n];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
        }
    }
}
