package com.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_7568 {
    static class P implements Comparable<P>{
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(P o) {
            int rx = Integer.compare(this.x, o.x);
            int ry = Integer.compare(this.y, o.y);
            if(rx > 0 && ry >0) {
                return -1;
            }else if (rx<0 && ry<0) return 1;
            else return 0;
        }
    }
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<P> origin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            origin.add(new P(x, y));
        }
        for (int i = 0; i < origin.size(); i++) {
            System.out.print(origin.get(i)+ " ");
        }
        System.out.println();
        System.out.println("-----------------");
        Collections.sort(origin);
        for (int i = 0; i < origin.size(); i++) {
            System.out.print(origin.get(i)+ " ");
        }
        System.out.println();

    }

}
