package com.boj;

import java.util.*;

public class Main_11286 {
    static int n;
    static int x;
    static PriorityQueue<Integer> queue;
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();

       queue = new PriorityQueue<>((o1, o2)->{
           int abs1 = Math.abs(o1);
           int abs2 = Math.abs(o2);
           if(abs1 == abs2) return o1 > o2 ? 1: -1;
           return abs1 - abs2;
       });

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            if(x == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(x);
            }
        }

    }
}
