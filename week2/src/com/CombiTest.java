package com;

import java.util.Arrays;

public class CombiTest {
    static int[] p = {1,2,3,4,5};
    static int n = p.length;
    static int r;
    static int count;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) {
            r =3;
            nums = new int[r];
            visited = new boolean[n];
            combi(0, 0);
            System.out.println(count);
        }

        private static void combi(int start, int cnt) {
            if(cnt == r){
                count ++;
                for (int i = 0; i < n; i++) {
                    if(visited[i]) System.out.print(p[i] + " ");
                }
                System.out.println();
//                System.out.println(Arrays.toString(nums));
                return;
            }
            for (int i = start; i < n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                nums[cnt] = p[i];
                combi(i+1,cnt+1);
                nums[cnt] = 0;
                visited[i] = false;
            }
        }
}
