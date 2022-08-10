package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
* 홀수일때 DSC
* 짝수일때 ASC
* max < min일 경우 swap 수행
* 각각으 peek 가져와서 비교 후 swap수행
*
* */
public class Main_1655_2 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

        }
    }
}
