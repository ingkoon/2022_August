package algol0826.com.boj;

import java.util.Scanner;

public class Main_10971 {
	static int n;
	static int [][] dist;
	static int min;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = sc.nextInt();				
			}
		}
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}			
		min = Integer.MAX_VALUE;
		do {
			int sum = 0;		
			for (int i = 0; i < n-1; i++) {
				if(dist[p[i]][p[i-1]] == 0) {
					break;
				}
				sum += dist[p[i]][p[i+1]];
			}
			sum += dist[p[n-1]][p[0]];
			min = Math.min(min, sum);
		}while(np(n-1));
		System.out.println(min);
	}
	private static boolean np(int size) {
		// TODO Auto-generated method stub
		int i = size;
		while(i > 0 && p[i-1] > p[i]) i--;
		if(i == 0) return false;
		int j = size;		
		while(p[i-1]> p[j]) j--;
		int temp = p[j];
		p[j] = temp;
		int k =size;
		while(i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		return true;
	}	
}
