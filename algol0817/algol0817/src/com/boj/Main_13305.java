package com.boj;

import java.util.Scanner;

public class Main_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lengths = new int[n-1];
        int[] city = new int[n];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = sc.nextInt();
        }
        for (int i = 0; i < city.length; i++) {
            city = new int[n];
        }

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < n-1; i++) {
            if(city[i] > city[i+1]){
                result += city[i] * lengths[i];
                continue;
            }

        }
    }
}
