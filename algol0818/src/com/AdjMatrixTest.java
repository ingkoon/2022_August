package com;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
    static int[][] adjMatrix;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int e = sc.nextInt();

        adjMatrix = new int[n][n];
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[from][to] = 1;
        }

        bfs();
    }

    private static void bfs() {
        // 0번 정점 시작점
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print((char)(cur+ 'A') + " ");

            // 현재 정점의 인접 정점들을 큐에 넣어서 차후에 탐색하도록 만들기
            for (int i = 0; i < n; i++) {
                if(!visited[i] && adjMatrix[cur][i] != 0){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
/*
test case
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
 */