package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1927 {
    static int n;
//    static PriorityQueue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            return o1 - o2;
        }));
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(x -> x));
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else queue.add(x);
        }
    }
}
