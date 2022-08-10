package com.boj;

import java.util.LinkedList;
import java.util.Queue;

public class Main_4963_bfs {
    static int[] dr = {-1, 1, 0 };
    static int[] dc = {};
    static int[][] map;
    static int h, w;
    public static void main(String[] args) {
        int group = 0;

    }
    private static void bfs(int rr, int cc, int g){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {rr, cc});
        map[rr][cc] = g;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 8; d++) {
                int nr = r +dr[d];
                int nc = c + dc[c];
                if(check(nr, nc)) continue;
                if(map[nr][nc]==1){
                    queue.offer(new int[] {nr, nc});
                    map[nr][nc] = g;
                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return(0<=nr&& nr<h && 0<=nc && nc <w);
    }
}
