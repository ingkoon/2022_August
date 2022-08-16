package com.jungol;

import java.util.Scanner;

public class Main_1828 {
    static int n;
    static C[] ref;
    static int result;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        ref=  new C[n];

        for (int i = 0; i < n; i++) {
            ref[i] = new C(sc.nextInt(), sc.nextInt());
        }

        int start = ref[0].x;
        int end = ref[0].y;

        for (int i = 1; i < ref.length; i++) {
            if(ref[i].x < start) continue;
            else if(ref[i].y > end){
                end = ref[i].y;
            }
            else{
             result ++;
             start = ref[i].x;
             end = ref[i].y;
            }
        }
        System.out.println(result+1);

    }

    static class C {
        int x;
        int y;
        public C(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

       public int getY(){
            return y;
        }


    }
}
