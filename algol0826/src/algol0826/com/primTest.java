package algol0826.com;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primTest {
	public static class Edge implements Comparable<Edge>{
		int node;
		double dis;
		
		public Edge(int node, int dis) {
			this.node = node;
			this.dis = dis;		
		}
						
		@Override
		public int compareTo(Edge o) {			
			return Double.compare(this.dis, o.dis);
		}
		
		static int V, E, ans  = 0, cnt = 0;
		static ArrayList<ArrayList<Edge>> graph;
		static boolean[] visited;
		static PriorityQueue<Edge> pq;
		
		public static void main(String[] args) {
			
		}
	}
}
