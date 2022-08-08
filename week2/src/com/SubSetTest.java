package com;

import java.util.Arrays;

public class SubSetTest {
    static int[] p = {1,2,3,4,5};
    static int n = p.length;
    static int r;
    static int count;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[n];
        perm(0, 0);
        System.out.println(count);
    }

    private static void perm(int cnt, int tot) {
        if(cnt == n){
            count ++;
            for (int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(p[i] + " ");
            }
            System.out.println();
            System.out.println("----->" + tot);
            return;
        }
        visited[cnt] = true;
        perm(cnt + 1, tot + p[cnt]);
        visited[cnt] = false;
        perm(cnt + 1, tot);
    }
}
