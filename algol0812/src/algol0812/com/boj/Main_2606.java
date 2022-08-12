package algol0812.com.boj;


import java.util.Scanner;

public class Main_2606 {
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
		dfs(0);
		System.out.println(cnt);
	}
	static void dfs(int num) {
		visited[num] = true;
		for (int i = 0; i < n; i++) {
			if(computers[num][i] != 0 && !visited[i]) {
				visited[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}
	
}
