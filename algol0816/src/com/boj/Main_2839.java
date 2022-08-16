package com.boj;

import java.util.Scanner;

public class Main_2839 {
    static int BIG = 5;
    static int SMALL = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        while(true){
            if(n % BIG == 0){
                result += n/BIG;
                break;
            }
            n -= SMALL;
            result++;
        }

        if(n < 0) System.out.println(-1);
        else System.out.println(result);
    }
}
