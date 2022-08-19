package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17135 {
    static int n, m, d;
    static int[][] field;
    static int ARCHER = 3;
    static boolean[][] visited;

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();

        field = new int[n+1][m];
        visited = new boolean[n+1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = sc.nextInt();
            }
        }
        ncr(0,0);
        System.out.println(result);
    }

    static void ncr(int cnt, int start){
        if(cnt == ARCHER){
            int tmp = startPhase(field);
            result = Math.max(tmp, result);

            return;
        }
        for (int i = start; i < m; i++) {
            if(visited[n][i]) continue;
            visited[n][i] = true;
            field[n][i] = 2;
            ncr(cnt+1, i+1);
            visited[n][i] = false;
            field[n][i] = 0;
        }
    }

    private static int startPhase(int[][] field) {
        int[][] tmpfield = new int[n+1][m];
        int[] archers = new int[3];
        int[] enemy = new int[2];
        int aCnt = 0;
        int kill = 0;
        //배열 복사
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m; j++) {
                tmpfield[i][j] = field[i][j];

                if(tmpfield[i][j] == 2) {
                    archers[aCnt] = j;
                    aCnt++;
                    }
                }
            }

        while(!isWin(tmpfield)) {
            int[][] dieSoon = new int[3][2];
            int dicCnt = 0;
            for (int archer: archers) {
                enemy = shootArrow(archer, tmpfield);
                if(enemy[0] == Integer.MAX_VALUE || enemy[1] == Integer.MAX_VALUE) continue;
                if (tmpfield[enemy[0]][enemy[1]] == 1) {
                    dieSoon[dicCnt][0] = enemy[0];
                    dieSoon[dicCnt++][1] = enemy[1];

                }
            }

            for (int[] ints : dieSoon) {
                if(tmpfield[ints[0]][ints[1]] == 1) {
                    tmpfield[ints[0]][ints[1]] = 0;
                    kill++;

                }
            }
//            for (int[] f : tmpfield) {
//                System.out.println(Arrays.toString(f));
//            }
//            System.out.println("--------------------------");
            //한칸 땡기기
            for (int i = 0; i < m; i++) {
                tmpfield[n-1][i] = 0;
            }

            for (int i = n-2; i >=0; i--) {
                for (int j = 0; j < m; j++) {
                    if(tmpfield[i][j] == 1){
                        tmpfield[i+1][j] = 1;
                        tmpfield[i][j] = 0;
                    }
                }
            }
        }
        return kill;
    }

    private static int[] shootArrow(int archer, int[][] tmpField) {
        int distance = d;
        int r = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        boolean isFlag = false;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if(tmpField[i][j] == 1 && (Math.abs(archer - j) + Math.abs(n - i)) <= distance){    //제일 왼쪽거 ^^
                    distance = Math.abs(archer - j) + Math.abs(n - i);
                    r = i;
                    c = j;
                }
                if(i+1 ==n) continue;
                for (int k = i + 1; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if(tmpField[k][l] == 1) {
                            isFlag = true;

                        }
                    }
                }
                if(!isFlag) return new int[]{r,c};
            }
        }
        return new int[]{r,c};
    }

    private static boolean isWin(int[][] tmpfield) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmpfield[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static boolean isCheck(int r, int c){
        return (0<= r && r<n+1 && 0 <=c && c < m);
}
}
/*
* 동시에 죽이기
* 가장 왼쪽값 찾기
* */