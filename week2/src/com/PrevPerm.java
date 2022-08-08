package com;

import java.util.Arrays;

public class PrevPerm {
    static int[] p = {5,4,3,2,1}; // 1000000000반복 -> 0.8 12! 20!
    static int count;
    static int n = p.length;
    public static void main(String[] args) {
        do {
            count++;// 자기자신 포함, 최소 한번
            System.out.println(Arrays.toString(p));
        }while(pp(n-1));
        System.out.println(count);
    }

    private static boolean pp(int size) {
        int i = size;
        while(i>0 && p[i-1] < p[i]) i--;
        if(i == 0) return false;
        int j = size;
        while(p[i-1]<p[j]) j--;
        int tmp = p[i-1];
        p[i-1] = p[j];
        p[j] = tmp;
        int k = size;
        while(i <k){
            tmp = p[i];
            p[i] = p[k];
            p[k] = tmp;
            i ++;
            k--;
        }
        return true;
    }
}
