package com.boj;

public class Main_4963 {
    static int[] dr = {-1, 1, 0 };
    static int[] dc = {};
    static int[][] map;
    static int h, w;
    public static void main(String[] args) {

    }
    private static void dfs(int r, int c, int g){
        map[r][c] = g; //2~
        for (int d = 0; d < 8; d++) {
            int nr = r +dr[d];
            int nc= c + dc[c];
            if(check(nr, nc)) continue;
            if(map[nr][nc]==1){
//                map[nr][nc] = g; //visited 사용 x => group 표시
                dfs(nr, nc, g);
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return(0<=nr&& nr<h && 0<=nc && nc <w);
    }
}
