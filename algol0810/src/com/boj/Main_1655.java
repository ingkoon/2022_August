package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1655 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) ->
//        {return o2 -o1;}
//        );
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        int x = Integer.parseInt(br.readLine());
        minQueue.add(x);
        System.out.println(x);
        for (int i = 0; i < n-1; i++) {
            x = Integer.parseInt(br.readLine());
            if(minQueue.size()+ maxQueue.size()%2 ==0 &&minQueue.peek() > x){
                maxQueue.add(minQueue.poll());
                minQueue.add(x);
            } else if(minQueue.size()+ maxQueue.size()%2 ==0 &&maxQueue.peek() < x){
                minQueue.add(maxQueue.poll());
                maxQueue.add(x);
            } else if(x > maxQueue.peek()) maxQueue.add(x);
            else minQueue.add(x);
        }
    }
}
