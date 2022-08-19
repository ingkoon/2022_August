package com.boj;

import java.util.*;

public class Main_2606_aj {
    static int n, m;
    static List<Integer>[] lists;

    static int result;
    static int resultV2;
    static boolean[] visited;
    static boolean[] visitedV2;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            lists[s].add(e);
            lists[e].add(s);
        }
        // 읽기 완료

        visited = new boolean[n];
        visitedV2 = new boolean[n];

        // 로직
        dfs(0);
        bfs(0);
        System.out.println(result-1);
        System.out.println(resultV2);
    }

    private static void dfs(int loc) {
        visited[loc] = true;
        result++;

        for (Integer list : lists[loc]) {
            if (!visited[list]) dfs(list);
        }
    }
    private static void bfs(int loc){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(lists[loc]);
        visitedV2[loc] = true;
        while (!queue.isEmpty()){
            List<Integer> list = queue.poll();
            for (Integer l : list) {
                if(!visitedV2[l]){
                    resultV2++;
                    visitedV2[l] = true;
                    queue.offer(lists[l]);
                }
            }
        }
    }
}
