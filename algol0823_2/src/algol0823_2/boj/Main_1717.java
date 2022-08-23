package algol0823_2.boj;

import java.util.Scanner;

public class Main_1717 {
	static int n, m;
	static int[][] calc;
	static int[] p;
	static int[] r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt()+1;		
		m = sc.nextInt();
		
		calc = new int[m][3];
		for (int i = 0; i < m; i++) {
			calc[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		
		makeSet();
		
		for(int[] c : calc) {
			if(c[0] == 0) union(c[1], c[2]);
			else System.out.println(find(c[1]) == find(c[2]) ? "YES" : "NO");									
		}
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		
	}
	private static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]); //최종 부모까지 올라간다.
	}
	private static void makeSet() {
		// TODO Auto-generated method stub
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;			
		}
		r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = i;			
		}
	}
		
}
