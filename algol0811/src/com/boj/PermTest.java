package com.boj;

import java.util.Arrays;

public class PermTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;

    static int r;
    static int count;

    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) {
        r = 3;
        
        nums = new int[r];
        visited = new boolean[n];
        
        npr(0);
        System.out.println("count = " + count);
    }

    //대칭적인 구조 -> 백트래킹
    private static void npr(int cnt) {
        if(cnt == r){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }


        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i]=true;
            nums[cnt] = p[i];
            npr(cnt+1);
            visited[i] = false;
        }
    }
}
