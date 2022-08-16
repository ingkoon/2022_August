package com.boj;

import java.util.Scanner;

public class Main_1074 {
    static int n;
    static int r, c;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int size = (int)Math.pow(2, n);
        r = sc.nextInt();
        c = sc.nextInt();
        z(size, r, c);
        // 구현

        System.out.println(result);
    }

    public static void z(int size, int r, int c){
        if(size == 1) return;

        if(r < size/2 && c < size /2) z(size/2, r, c);
        else if(r < size/2 && c >= size/2){
            result += size * size/4;
            z(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2){
            result += (size * size/4) * 2;
            z(size/2, r - size/2 , c);
        }
        else{
            result += (size * size/4) * 3 ;
            z(size/2, r - size/2, c - size/2);
        }
    }
}
