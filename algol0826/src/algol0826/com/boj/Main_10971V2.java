package algol0826.com.boj;

import java.util.Scanner;

public class Main_10971V2 {
	static int n;
	static int [][] dist;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = sc.nextInt();				
			}
		}
		
		min = Integer.MAX_VALUE;
		tsp(0, new boolean[n], new int[n]);
		System.out.println(min);
	}
	private static void tsp(int cnt, boolean[] visited, int[] nums) {
		if(cnt == n) {
			// A B C + A의 작업을 수행해 주어야 한다.
			int sum = 0;		
			for (int i = 0; i < n-1; i++) {
				if(dist[nums[i]][nums[i+1]] == 0) {
					return;
				}
				sum += dist[nums[i]][nums[i+1]];
			}
			sum += dist[nums[n-1]][nums[0]];
			min = Math.min(min, sum);
			return;					
		}
		
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = i;
			tsp(cnt+1, visited, nums);
			nums[cnt] = 0;
			visited[i] = false;			
		}
	}
}
