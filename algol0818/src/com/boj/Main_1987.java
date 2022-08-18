package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
    static int r, c;
    static char[][] board;

    static int result;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        index = new int[26];
        for (int i = 0; i < r; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        dfs(0, 0);

        System.out.println(result == 0 ? 1 : result);
    }

    private static void dfs(int pr, int pc) {
        //포함되어 있을 경우 현재까지 진행된 값을 갖고 비교 후 결과 재할당
        if (isDuplicate(pr, pc)){
            int tmp = 0;
            for (int i = 0; i < index.length; i++) {
                if(index[i] == 1) tmp++;
            }
            result =  Math.max(result, tmp);
            return;
        }



        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if(isCheck(nr, nc)){
                index[board[pr][pc] -'A'] = 1;
                dfs(nr, nc);
                index[board[pr][pc] -'A'] = 0;
            }
        }
    }

    private static boolean isCheck(int nr, int nc) {
        return (0<=nr && nr< r && 0 <= nc && nc < c);
    }

    private static boolean isDuplicate(int dr, int dc){
        return index[board[dr][dc]-'A'] == 1;
    }
}
