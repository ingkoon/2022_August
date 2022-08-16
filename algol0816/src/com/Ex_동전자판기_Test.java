package com;

import java.util.Scanner;

public class Ex_동전자판기_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetMoney = sc.nextInt();

        int[] unit = {500, 100, 50, 10, 5, 1};
        int[] counts = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int totalMoney = 0;
        for (int i = 0, size = unit.length; i < size; i++) {
            totalMoney += unit[i] * counts[i];
        }

        int remainMoney = totalMoney + targetMoney;

        int sum = 0, maxCnt, availCnt;
        for (int i = 0, size = unit.length; i < size; i++) {
            maxCnt = remainMoney/unit[i];
            availCnt = Math.min(maxCnt, counts[i]);

            counts[i] -= availCnt;
            remainMoney -= availCnt * unit[i];
        }
        System.out.println(sum);

        for(int count : counts) {
            System.out.println(count + " ");

        }
    }
}
