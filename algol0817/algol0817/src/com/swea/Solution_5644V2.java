package com.swea;

import java.util.*;

public class Solution_5644V2 {

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

            for (int i = 0; i < m; i++) {
                int moveA = userA[i];
                int moveB = userB[i];

                A.r += userDr[moveA];
                A.c += userDc[moveA];

                B.r += userDr[moveB];
                B.c += userDc[moveB];

                if(bfs()){
                    if(map[A.r][A.c][1] != 0){
                        int[] tmpA = Arrays.copyOfRange(map[A.r][A.c],1, 8);
                        Arrays.sort(tmpA);
                        if(tmpA[0] > map[A.r][A.c][0] / 2){
                            A.result+=tmpA[0];
                            B.result+=map[B.r][B.c][0];
                        } else{
                            A.result+=map[A.r][A.c][0]/2;
                            B.result+=map[B.r][B.c][0]/2;
                        }
                    }
                    else if(map[B.r][B.c][1] != 0){
                        int[] tmpB = Arrays.copyOfRange(map[B.r][B.c], 1, 8);
                        Arrays.sort(tmpB);
                        if(tmpB[0]> map[B.r][B.c][0] / 2){
                            A.result+=map[A.r][A.c][0];
                            B.result+=tmpB[0];
                        } else{
                            A.result+=map[A.r][A.c][0]/2;
                            B.result+=map[B.r][B.c][0]/2;
                        }
                    }else {
                        A.result+=map[A.r][A.c][0]/2;
                        B.result+=map[B.r][B.c][0]/2;
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
        if(map[A.r][A.c][0] != map[B.r][B.c][0]) return false;

        boolean[][] visited = new boolean[10][10];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {A.r, A.c});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == B.r && tmp[1] == B.c) return true;
            visited[tmp[0]][tmp[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dr[i];
                int nc = tmp[1] + dc[i];
                if(isChecked(nr, nc) && map[nr][nc][0]!=0 && !visited[nr][nc]){
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        return false;
    }
}//
