package algol0824.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
	static int r, c;
	static String[][] forest;
	static int result;
	static Queue<int[]> queue;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		forest = new String[r][c];
		visited = new int[r][c];
		
		queue = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			char[] tmp = bf.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				forest[i][j] = tmp[j]+"";	
				if(forest[i][j].equals("S")) {
					queue.add(new int[] {i,j});		
			}
			}
		}
		
		for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(forest[i][j].equals("*")) {
						queue.add(new int[] {i,j});												
				}
			}
		}
		System.out.println(bfs());
	}
	
	static String bfs() {
		while(!queue.isEmpty()) {		
			int[] hedge = queue.poll();
			
			int pr = hedge[0];
			int pc = hedge[1];
			
			for (int i = 0; i < 4; i++) {
				
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				if(isCheck(nr, nc)) {
					if((forest[nr][nc].equals(".") || forest[nr][nc].equals("D"))
							&& forest[pr][pc].equals("S")) {
						if(forest[nr][nc].equals("D")) 
							return visited[pr][pc]+1 + "";
						forest[nr][nc] = "S";
						visited[nr][nc] = visited[pr][pc] + 1;
						queue.offer(new int[] {nr, nc});
						
					}else if((forest[nr][nc].equals(".") || forest[nr][nc].equals("S"))
							&& forest[pr][pc].equals("*")) {
						forest[nr][nc] = "*";
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
		return "KAKTUS";	
	}
	
	static boolean isCheck(int nr, int nc) {
		return (0<=nr && nr < r && 0<=nc && nc < c);
	}
}
 