package com;

import java.util.Scanner;

public class SquareNumberTest {
    static int callCnt;
    static int callCnt2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(exp1(x, n));
        System.out.println(callCnt);

        System.out.println(exp2(x, n));
        System.out.println(callCnt2);
    }
    static  long exp1(int x, int n){
        callCnt++;
        if(n == 1) return x;
        return x * exp1(x, n-1);
    }

    static long exp2(int x, int n){
        callCnt2++;
        if(n == 1) return x;
        long y = exp2(x, n/2);
        return n%2 ==0 ? y*y: y*y*x;
    }
}
