package algol0823_2.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1922 {
	
	
	
	static int n, m;
	static List<Computer> computers;
	static int[] p;	
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		p = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		computers = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			computers.add(new Computer(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(computers, (a, b)-> a.getWeight() - b.getWeight());
		
		for(Computer c : computers) {
			if(find(c.to) != find(c.from)) {
				union(c.to, c.from);
				result += c.getWeight();
			}
		}
		
		System.out.println(result);
	}
	
	public static int find(int x) {
		if(p[x] == x) return x;
		else return p[x] = find(p[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) {
			p[x] = y;
		}else {
			p[y] = x;
		}
	}
	
	static class Computer{
		 int to;
		 int from;
		 int weight;
		
		public Computer(int to, int from, int weight) {
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
