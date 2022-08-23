package algol0823_2.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023 {
	static int n, m;
	static boolean[] visited;
	static int[][] friends;
	static List<ArrayList<Integer>> graph;
	static boolean isFlag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		friends = new int[n][n];
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph.get(to).add(from);
			graph.get(from).add(to);
		}
		
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 1);
		}
		
		int result = isFlag ? 1 : 0; 
		System.out.println(0);
	}
	
	static void dfs(int x, int cnt) {		
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		visited[x] = true;
		for (int a : graph.get(x)) {
			// 방문한 적이 없어야 한다.
			if(!visited[a]) //백트래킹 수행
				dfs(a, cnt+1);
		}
	
		visited[x] = false;
	}
}
