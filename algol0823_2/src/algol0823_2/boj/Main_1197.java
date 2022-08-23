package algol0823_2.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1197 {
	static int v;
	static int e;
	static int[] p;
	static List<Edge> list;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		p = new int[v+1];
		for (int i = 0; i < v; i++) {
			p[i]= i;
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list, (a, b) -> a.getWeight() - b.getWeight());
		
		for(Edge edge : list) {		
			if(find(edge.getTo()) != find(edge.getFrom())) {
				union(edge.getTo(), edge.getFrom());
				result += edge.getWeight();				
			}
		}
		
		System.out.println(result);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) {
			p[x] = y;			
		} else {
			p[y] = x;			
		}		
	}
	
	private static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}

	static class Edge{
		int to;
		int from;
		int weight;		
		public Edge(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
		public int getTo() {
			return to;
		}
		public int getFrom() {
			return from;
		}
		public int getWeight() {
			return weight;
		}
		
	}
}
