package com.boj;

import java.util.Scanner;

public class Main_15683 {
    static int n, m;
    static String[][] office;

    static int cctvCnt;
    static CCTV[] cctvs;

    static int result;
    static class CCTV{
        int number;
        int r;
        int c;
        public CCTV(int number, int r, int c){
            this.number = number;
            this.r = r;
            this.c = c;
        }
    }

    static int[] case1r = {0, 0, 1, -1};
    static int[] case1c = {1, -1, 0,0};

    static int[] case2 = {-1, 1};

    static int [] case3r = {-1, 1, 1, -1};
    static int [] case3c = {1, 1, -1, -1};

    static int [] case4r1 = {-1, -1, 0, -1};
    static int [] case4r2 = {0, 1, 1, 1};
    static int [] case4c1 = {-1, 0 , -1, -1};
    static int [] case4c2 = {1, 1, 1, 0};


    static int [] case5r1 = {-1};
    static int [] case5r2 = {1};
    static int [] case5c1 = {-1};
    static int [] case5c2 = {1};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        office = new String[n][m];

        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                office[i][j] = sc.nextInt()+"";
                if(!office[i][j].equals("0") && !office[i][j].equals("6")) cctvCnt++;
            }
        }
        int cnt = 0;
        cctvs = new CCTV[cctvCnt];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!office[i][j].equals("0") && !office[i][j].equals("6")){
                    cctvs[cnt++] = new CCTV(Integer.parseInt(office[i][j]), i, j);
                }
            }
        }
        runCctv(0, office);
        System.out.println(result);
    }

    public static void runCctv(int cnt, String[][] map){
        //검증
        if(cnt == cctvCnt){
            int tmp = 0;

            for (String[] m : map) {
                for (String i : m) {
                    if(i.equals("0")){
                        tmp++;
                    }
                }
            }
            //배열 내 모든 0의 개수 카운팅
            result = Math.min(result, tmp);
            return;
        }

        //배열 복사
        String[][] tmp = new String[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        //모든 가능성 체크
        for (int i = 0; i < 4; i++) {
            String[][] nOffice = changeDirection(cctvs[cnt],tmp, i);
            runCctv(cnt+1, nOffice);
            tmp = initOffice(tmp, map);
        }
    }

    private static String[][] initOffice(String[][] tmp, String[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    private static String[][] changeDirection(CCTV cctv, String[][] tmpMap, int d) {
        int r;
        int c;
        switch (cctv.number){
            case 1:
                r = cctv.r;
                c = cctv.c;
                while (true){
                    r += case1r[d];
                    c += case1c[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                break;

            case 2:
                if(d%2 == 0){
                    r = cctv.r;
                    c = cctv.c;
                    while (true){
                        r += case2[d/2];
                        if(!isCheck(r, c, tmpMap)) break;
                        tmpMap[r][c] = "#";
                    }
                    r = cctv.r;
                    while (true){
                        r -= case2[d/2];
                        if(!isCheck(r, c, tmpMap)) break;
                        tmpMap[r][c] = "#";
                    }
                } else{
                    r = cctv.r;
                    c = cctv.c;
                    while (true){
                        c += case2[d/2];
                        if(!isCheck(r, c, tmpMap)) break;
                        tmpMap[r][c] = "#";
                    }
                    c = cctv.c;
                    while (true){
                        c -= case2[d/2];
                        if(!isCheck(r, c, tmpMap)) break;
                        tmpMap[r][c] = "#";
                    }
                }
                break;

            case 3:
                r = cctv.r;
                c = cctv.c;
                while (true){
                    r += case3r[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                r = cctv.r;
                while (true){
                    c += case3c[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                break;

            case 4:
                r = cctv.r;
                c = cctv.c;
                while (true){
                    if(case4r1[d]==0) break;
                    r += case4r1[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                r = cctv.r;
                while (true){
                    if(case4r2[d]==0) break;
                    r += case4r2[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                r = cctv.r;
                while (true){
                    if(case4c1[d]==0) break;
                    c += case4c1[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                c = cctv.c;
                while (true){
                    if(case4c2[d]==0) break;
                    c += case4c2[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                break;

            case 5:
                r = cctv.r;
                c = cctv.c;
                d = 0;
                while (true){
                    r += case5r1[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                r = cctv.r;
                while (true){
                    r += case5r2[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                r = cctv.r;
                while (true){
                    c += case5c1[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                c = cctv.c;
                while (true){
                    c += case5c2[d];
                    if(!isCheck(r, c, tmpMap)) break;
                    tmpMap[r][c] = "#";
                }
                break;
            default:
                break;
        }
        return tmpMap;
    }
    private static boolean isCheck(int nr, int nc, String[][] map){
        return (0<= nr && nr<n && 0<= nc && nc < m) && !map[nr][nc].equals("6");
    }
}
