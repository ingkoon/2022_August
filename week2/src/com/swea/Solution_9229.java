package com.swea;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution_9229 {
    static int T, n, m, r, result;
    static int[] weights;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(new File("src/com/swea/sample_input.txt"));
        T = sc.nextInt();
        r = 2;

        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            weights = new int[n];
            visited =new boolean[n];
            result = -1;
            for (int i = 0; i < n; i++) weights[i] = sc.nextInt();

            calc(0,0);
            System.out.printf("#%d %d\n", t, result);

        }
    }
    private static void calc(int val, int cnt){
        if(cnt == r){
            if(val <= m) result = Math.max(val, result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            val += weights[i];
            calc(val, cnt+1);
            visited[i] = false;
            val -= weights[i];
        }

    }
}
