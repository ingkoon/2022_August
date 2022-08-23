package algol0823_2;

import java.util.Arrays;

public class UFTest {
	
	static int[] p;
	static int[] r;
	static int n;
	public static void main(String[] args) {
		n = 6;
		makeSet();
		union(0, 1);
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(r));
		
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
		
	}
	
	private static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]); //최종 부모까지 올라간다.
	}
	
	private static void makeSet() {
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		
		r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = 1;
		}
		
	} 

}
