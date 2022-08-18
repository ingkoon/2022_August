package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1987V2 {
    static int r, c;
    static List<String> duplicatedChars;
    static String[][] board;

    static int result;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new String[r][c];

        duplicatedChars = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp[j] + "";
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int pr, int pc) {
        //포함되어 있을 경우 현재까지 진행된 값을 갖고 비교 후 결과 재할당
        if (isDuplicate(pr, pc)){
            result = Math.max(result, duplicatedChars.size());
            return;
        }

        duplicatedChars.add(board[pr][pc]);

        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if(isCheck(nr, nc)){
                dfs(nr, nc);
            }
        }
    }

    private static boolean isCheck(int nr, int nc) {
        return (0<=nr && nr< r && 0 <= nc && nc < c);
    }

    private static boolean isDuplicate(int dr, int dc){
        return duplicatedChars.contains(board[dr][dc]);
    }
}
