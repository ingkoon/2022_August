package com.boj;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main_3040 {
    static int[] dwarfs;
    static int n = 9;
    static int r = 7;
    static int[] sevenDwarfs;
    static boolean[] visited;
    public static void main(String[] args) {
        dwarfs = new int[n];
        visited = new boolean[n];

        sevenDwarfs = new int[r];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            dwarfs[i] = sc.nextInt();
        }
        ncr(0,0);
    }

    static void ncr(int cnt, int start){
        if(cnt == r){
            if ( IntStream.of(sevenDwarfs).sum() == 100) {
                for (int sevenDwarf : sevenDwarfs) {
                    System.out.println(sevenDwarf);
                }
            }
            return;
        }
        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sevenDwarfs[cnt] = dwarfs[i];
            ncr(cnt+1, i+1);
            visited[i] = false;
        }
    }
}
