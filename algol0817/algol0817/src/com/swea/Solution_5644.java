package com.swea;

import java.util.*;

public class Solution_5644 {

    static int T;
    static int m, a;
    static int[] userA;
    static int[] userB;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] userDr = {0, -1, 0 , 1, 0};
    static int[] userDc = {0, 0, 1 , 0, -1};
    static int[][][] map;

    static User A;
    static User B;
    static class User{
        int r;
        int c;
        int result;

        public User(int r, int c, int result){
            this.r = r;
            this.c = c;
            this.result = result;
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            m = sc.nextInt();
            a = sc.nextInt();

            userA = new int[m];
            userB = new int[m];
            map = new int[10][10][8];

            for (int i = 0; i < m; i++) {
                userA[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                userB[i] = sc.nextInt();
            }

            for (int i = 0; i < a; i++) {
                dfs(sc.nextInt()-1, sc.nextInt()-1,0, sc.nextInt(), sc.nextInt());
            }

            A= new User(0,0,map[0][0][0]);
            B= new User(9,9,map[9][9][0]);

            A.result+=map[0][0][0];
            B.result+=map[9][9][0];

            for (int i = 0; i < m; i++) {
                int moveA = userA[i];
                int moveB = userB[i];

                A.r += userDr[moveA];
                A.c += userDc[moveA];

                B.r += userDr[moveB];
                B.c += userDc[moveB];

                if(bfs()){
                    int maxValA = 0;
                    int idxA = 0;
                    for (int j = 0; j < 8; j++) {
                        if(map[A.r][A.c][j] > maxValA) {
                            maxValA = map[A.r][A.c][j];
                            idxA = j;
                        }
                    }
                    int maxValB = 0;
                    int idxB = 0;
                    for (int j = 0; j < 8; j++) {
                        if(map[B.r][B.c][j] > maxValB) {
                            maxValB = map[B.r][B.c][j];
                            idxB = j;
                        }
                    }
                    if(idxA == idxB){
                        int[] tmpA = map[A.r][A.c].clone();
                        int[] tmpB = map[B.r][B.c].clone();
                        Arrays.sort(tmpA);
                        Arrays.sort(tmpB);
                        int tmpVal = Math.max(tmpA[6], tmpB[6]);
                        A.result += tmpVal;
                        B.result += maxValB;
                    }
                    else{
                        A.result += maxValA/2;
                        B.result += maxValB/2;
                    }
                }
                else{
                    A.result += map[A.r][A.c][0];
                    B.result += map[B.r][B.c][0];
                }
            }
            System.out.printf("#%d %d\n", t, A.result+B.result);

        }
    }

    static void dfs(int c, int r, int start, int depth, int val){
        if(start == depth) return;
        if(map[r][c][0] == 0) map[r][c][0] = val;
        else {
            for (int i = 0; i < 8; i++) {
                if(map[r][c][i] ==0) {
                    map[r][c][i] = val;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isChecked(nr, nc)){
                if(map[nr][nc][0] == 0) map[nr][nc][0] = val;
                else{
                    map[nr][nc][1] = val;
                }
                dfs(nc, nr, start+1, depth, val);
            }
        }
    }

    static boolean isChecked(int nr, int nc){
        return (0 <= nr && nr < 10 && 0 <= nc && nc < 10);
    }

    static boolean bfs(){
        if(map[A.r][A.c][0] == map[B.r][B.c][0]) {
            boolean[][] visited = new boolean[10][10];

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{A.r, A.c});
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                if (tmp[0] == B.r && tmp[1] == B.c) return true;
                visited[tmp[0]][tmp[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = tmp[0] + dr[i];
                    int nc = tmp[1] + dc[i];
                    if (isChecked(nr, nc) && map[nr][nc][0] != 0 && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }
}
