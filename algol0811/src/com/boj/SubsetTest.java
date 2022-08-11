package com.boj;

import java.util.Arrays;

public class SubsetTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;

    static int r;
    static int count;

    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) {
        r = 3;
        visited = new boolean[n];
        subSet(0, 0);
        System.out.println("count = " + count);
    }

    //대칭적인 구조 -> 백트래킹
    private static void subSet(int cnt, int tot) {
        if(cnt == n){
            count++;
            for (int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(p[i]);
            }
            System.out.println();
            System.out.println("-------------->" + tot);
            return;
        }
        visited[cnt]=true;
        subSet(cnt+1, tot+ p[cnt]);
        visited[cnt] = false;
        subSet(cnt+1, tot + p[cnt]);
        }

}
