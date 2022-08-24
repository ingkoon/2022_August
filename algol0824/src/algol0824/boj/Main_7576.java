package algol0824.boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576 {
	static int c, r;
	static int[][] tomatos;
	static int[][] visited;
	static Queue<int[]> queue;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		
		tomatos = new int[r][c];
		visited = new int[r][c];
		
		queue = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				tomatos[i][j] = sc.nextInt();
				if(tomatos[i][j]== 1) {
					queue.add(new int[] {i, j});
					visited[i][j] = 1;
				}
				if(tomatos[i][j] == -1) {
					visited[i][j] =-1;
				}
			}
		}
		
		bfs();
		int result = Integer.MIN_VALUE;
		boolean isFlag = true;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(visited[i][j] == 0) isFlag = false;
				result = Math.max(result, visited[i][j]);
			}
		}
		if(isFlag)
			System.out.println(result - 1);
		else System.out.println(-1);
	}
	private static void bfs() {				
		while(!queue.isEmpty()) {			
			int[] q = queue.poll();
			int pr = q[0];
			int pc = q[1];
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				if(!isCheck(nr, nc)) continue;
				if(tomatos[nr][nc] == 0 && tomatos[pr][pc] >= 1) {
					tomatos[nr][nc] = 1;
					visited[nr][nc] = visited[pr][pc] + 1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	
	static boolean isCheck(int nr, int nc) {
		return 0 <= nr && nr < r && 0 <= nc && nc < c;
	}
}
