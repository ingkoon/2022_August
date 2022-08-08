package com;

public class PowerSetTest {
    static int[] p = {1,2,3,4,5};
    static int n = p.length;

    // 10001
    // 1   5
    // 1<<0 1
    // 1<<1 10
    // 1<<2 100
    // 1<<3 1000
    // 1<<4 10000
    // 1<<5 100000
    public static void main(String[] args) {
        for (int i = 0; i < (1<<n); i++){
            for (int j = 0; j < n; j++) {
                if((i & (1<<j)) !=0){
                    System.out.print(p[j] + " ");
                }
            }
            System.out.println();
        }
    }


}
