package algol0824.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
	
	static int n;
	static char[][] pic;
	static char[][] jlsy;	
	static boolean[][] visited;
	
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static char[] js = {'G', 'R'};

	static int nResult;
	static int jsResult;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		pic = new char[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			pic[i] = bf.readLine().toCharArray();		
		}		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfs(i, j, pic[i][j]);
			}			
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				jsBfs(i, j, pic[i][j]);
			}			
		}
		
		System.out.println(nResult + " " + jsResult);
	}
	
	static void bfs(int r, int c, char color) {
		if(visited[r][c]== true) {
			return;
		}
		
		nResult ++;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int pr = q[0];
			int pc = q[1];
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(!isCheck(nr, nc) || visited[nr][nc]) continue;
				if(pic[nr][nc] == color) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

	static void jsBfs(int r, int c, char color) {
		if(visited[r][c]== true) {
			return;
		}
		
		jsResult ++;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int pr = q[0];
			int pc = q[1];
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(!isCheck(nr, nc) || visited[nr][nc]) continue;
//				if(Arrays.asList(js).contains(pic[nr][nc]) && Arrays.asList(js).contains(color)) {
//					visited[nr][nc] = true;
//					queue.offer(new int[] {nr, nc});
//				}
				if( (color == 'R' || color == 'G' )&& (pic[nr][nc] == 'R' || pic[nr][nc] == 'G')) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
				
				else if(pic[nr][nc] == color && pic[nr][nc] == 'B') {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	private static boolean isCheck(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}
}
