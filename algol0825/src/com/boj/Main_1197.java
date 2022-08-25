package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1197 {
    static int V, E;
    static class Edge implements Comparable<Edge>{
        int v;
        int weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }
    static List<Edge>[] adj;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        adj=new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
            adj[e].add(new Edge(s, w));
        }// 읽기
        System.out.println(prim());
    }
    private static long prim() {
        long min=0L;
        boolean [] visited=new boolean[V+1];
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int i = 0; i < V+1; i++) {
            int w = -1;
            int minVal = Integer.MAX_VALUE;
            for(int j = 1; j < V+1; j++){
                if(!visited[j] && minVal > distance[j]){
                    minVal = distance[j];
                    w = j;
                }
                visited[w] = true;
                min += minVal; // w -> v까지의 최소 값을 구한 것
                for (int k = 0; k < adj[w].size(); k++) {
                    Edge v = adj[w].get(j);
                    if(!visited[v.v] && v.weight < distance[v.v]){
                        distance[v.v] = v.weight;
                    }
                }
            }
        }

        return min;
    }
}
