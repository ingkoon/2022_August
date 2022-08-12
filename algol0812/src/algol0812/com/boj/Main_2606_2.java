package algol0812.com.boj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606_2 {
	static int[][] computers;
	static boolean[] visited;
	static int n;
	static int p;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
		
		visited = new boolean[n];		
		computers = new int[n][n];
		
		for (int i = 0; i < p; i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			computers[start][end] = 1;	
			computers[end][start] = 1;	
		}
		bfs(0);
		System.out.println(cnt);
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {			
			int tmp = q.poll();
			for (int i = 0; i < n; i++) {
				if(visited[i]) continue;
				if(computers[tmp][i]!=0) {					
					visited[i] = true;
					q.add(i);
					cnt++;
				}
			}
		}	
	}	
	
	
}
