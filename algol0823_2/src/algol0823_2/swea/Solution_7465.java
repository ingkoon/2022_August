package algol0823_2.swea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution_7465 {
	
	static int T;
	static int n, m;
	static int[] p;
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc= new Scanner(new File("s_input.txt"));
//		Scanner sc= new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			makeSet();
			
			for (int i = 0; i < m; i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				
				union(tmp1, tmp2);
				
			}
						
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i < p.length; i++) {
				set.add(find(p[i]));
			}
			System.out.printf("#%d %d\n",t, set.size());
		}
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) {
			p[y] =x;
		}else {
			p[x] = y;
		}
	}
	private static int find(int x) {
		if(p[x] == x) return x;
		else return p[x] = find(p[x]);
	}
	
	
	private static void makeSet() { 
		p = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			p[i] = i;
		}
	}
}
