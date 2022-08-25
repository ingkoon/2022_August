package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1753 {
    static int V, E, K;
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
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w)); //단방향
        }// 읽기
        System.out.println(dijkstra());
    }
    private static long dijkstra() {
        long min=0L;
        boolean [] visited=new boolean[V+1];
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE/100);
        distance[1] = 0;
        for (int i = 0; i < V+1; i++) {
            int w = -1;
            int minVal = Integer.MAX_VALUE/100;
            for(int j = 1; j < V+1; j++) {
                if (!visited[j] && minVal > distance[j]) {
                    minVal = distance[j];
                    w = j;
                }
            }
            if(w==-1) break; // prim은 사용하지 않는다.
            visited[w] = true;
//                min += minVal; // w -> v까지의 최소 값을 구한 것
            for (int j = 0; j < adj[w].size(); j++) {
                Edge v = adj[w].get(j);
                if(!visited[v.v] &&
                        distance[w] + v.weight < distance[v.v]){
                    distance[v.v] = distance[w] + v.weight;
                    }
                }
             }
            for (int j = 0; j < V+1; j++) {
                if(distance[j] == Integer.MAX_VALUE/100){
                    System.out.println("INF");
                }else{
                    System.out.println(distance[j]);
                }
            }


        return min;
    }
}
