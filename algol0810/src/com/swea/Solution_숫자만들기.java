package com.swea;

import java.io.*;
import java.util.*;

public class Solution_숫자만들기 {
    static int T;
    static int n;
    static int[] nums;
    static Set<Integer> results;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(
                new FileReader(new File("src/com/swea/4008.txt")));

        T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(bf.readLine());

            nums = new int[n];
            results =new HashSet<>();

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int add = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int mul = Integer.parseInt(st.nextToken());
            int div = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, add, min, mul, div, nums[0]);

            int maxVal = Collections.max(results);
            int minVal = Collections.min(results);

            System.out.printf("#%d %d\n", t, maxVal - minVal);
        }
    }

    private static void dfs(int cnt, int add, int min, int mul, int div, int result){
        if (cnt == n){
            results.add(result);
            return;
        }
        int tmp = result;
        if(add > 0){
            result += nums[cnt];
            dfs(cnt+1, add-1, min, mul, div, result);
        }
        result = tmp;
        if(min > 0){
            result -= nums[cnt];
            dfs(cnt+1, add, min-1, mul, div, result);
        }
        result = tmp;
        if(mul > 0){
            result *= nums[cnt];
            dfs(cnt+1, add, min, mul-1, div, result);
        }
        result = tmp;
        if(div > 0){
                result /=nums[cnt];
                dfs(cnt+1, add, min, mul, div-1, result);
        }
    }
}

