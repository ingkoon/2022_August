package com.swea;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution_6808 {
    static int T;
    static int SIZE = 9;
    static int[] gyu;
    static int[] in;

    static int[] cards;
    static boolean[] checked;
    static boolean[] visited;

    static int winCase;
    static int loseCase;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/com/swea/s_input.txt"));

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            gyu = new int[SIZE];
            in = new int[SIZE];
            cards = new int[SIZE];

            checked = new boolean[18];
            visited = new boolean[SIZE];

            winCase = 0;
            loseCase = 0;

            for (int i = 0; i < SIZE; i++) {
                int tmp = sc.nextInt();
                gyu[i] = tmp;
                checked[tmp-1] = true;
            }
            int cnt = 0;
            for (int i = 0; i < checked.length; i++) {
                if (!checked[i])
                    in[cnt++] = i + 1;
            }
            game(0);
            System.out.printf("#%d %d %d\n",t, winCase, loseCase);
        }


    }

    public static void game(int cnt){
        if(cnt == SIZE) {
            int gyuResult = 0;
            int inResult = 0;
            for (int i = 0; i < SIZE; i++) {
                if(gyu[i] > cards[i])
                    gyuResult += gyu[i] + cards[i];
                else
                    inResult += gyu[i] + cards[i];
            }
            if(gyuResult > inResult)
                winCase++;
            else
                loseCase++;
            return;
        }
        for(int i = 0; i< SIZE; i++){
            if(visited[i]) continue;
            visited[i] = true;
            cards[cnt] = in[i];
            game(cnt+1);
            visited[i] = false;
            cards[cnt] = 0;
        }
    }
}
