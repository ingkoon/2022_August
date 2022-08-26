package algol0826.com.boj;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_4485 {
	static int T;	
	static int n, result;
	static int[][] cave;
	static boolean[][] visited;	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		int t = 1;
		while(n!=0){	
			cave = new int[n][n];
			visited= new boolean[n][n];
			
			//입력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cave[i][j] = sc.nextInt();					
				}
			}
			
			result = bfs(0,0);			
			System.out.printf("Problem %d: %d\n",t, result);
			t++;
			n = sc.nextInt();			
		}
	}


	private static int bfs(int r, int c) {
		int tmp = Integer.MAX_VALUE;
		PriorityQueue<Rupee> pq = new PriorityQueue<>();
		int[][] dp= new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE/100);
		}
				
		dp[r][c] = cave[r][c]; 
		pq.offer(new Rupee(r, c, cave[r][c]));		
		
		while(!pq.isEmpty()) {
			Rupee l = pq.poll();
			int pr = l.r;
			int pc = l.c;
			int pVal = l.val;
			if(pr == n-1 && pc == n-1) {
				tmp = Math.min(tmp, dp[pr][pc]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];				
				if(!check(nr, nc)) continue;				
				if(dp[pr][pc] + cave[nr][nc] <  dp[nr][nc]) {
					dp[nr][nc] = Math.min(dp[pr][pc] + cave[nr][nc], dp[nr][nc]); 
					pq.offer(new Rupee(nr, nc, dp[nr][nc]));
				}
			}
		}
		return tmp;
	}

	

	private static boolean check(int nr, int nc) {	
		return 0<=nr && nr < n && 0 <= nc && nc < n;
	}
	
	static class Rupee implements Comparable<Rupee>{
		int r;
		int c;
		int val;
		public Rupee(int r, int c, int val){
			this.r = r;
			this.c = c;
			this.val = val;
		}
		@Override
		public int compareTo(Rupee o) {
			return this.val - o.val;
		}			
	}
}
