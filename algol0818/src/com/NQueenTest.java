package com;

import java.util.Scanner;

public class NQueenTest {
    static int n, result;
    static int[] cols;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = 0;
        cols = new int[n+1];

        setQueen(1);

        System.out.println(result);

    }

    public static void setQueen(int rowNo){ // 하나의 퀸만 가능한 모든곳에 놓아보기, 행 번호를 매개변수로 받는다.
       // 직전까지의 상황이 유망하지 않으면 현재 퀸을 놓을 필요가 없이니 백트래킹이다.
        if(rowNo>n){ // 퀸을 다 놓았을 경우
            result ++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            cols[rowNo] = i;
            if(isAvailable(rowNo)) setQueen(rowNo+1);
        }
    }

    private static boolean isAvailable(int rowNo) {
        for (int j = 1; j <rowNo; j++) {
            if(cols[j] == cols[rowNo]
                    || Math.abs(rowNo - j) == Math.abs(cols[rowNo] - cols[j])) return false;
        }
        return true;
    }
}
