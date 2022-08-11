package com.boj;

import java.util.Arrays;

public class PermTest2 {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;

    static int r;
    static int count;

    static int[] nums;
    public static void main(String[] args) {
        r = 3;

        nums = new int[r];

        npr(0, 0);
        System.out.println("count = " + count);
    }

    //비트 마스킹 구조 - 나중에 dfs의 시간초과가 발생할 경우 사용한다.
    private static void npr(int cnt, int flag) {
        if(cnt == r){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < n; i++) {
            if((flag & (1<<i)) != 0) continue;
            nums[cnt] = p[i];
            npr(cnt+1, (flag | (1<<i)));
            nums[cnt] = 0;
        }
    }
}
