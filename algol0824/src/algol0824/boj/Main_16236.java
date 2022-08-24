package algol0824.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236 {
	static int n, r, c;
	static int[][] sea;
	static boolean[][] visited;
	static List<int[]> feeds;
	
	
	static int size; // 아기상어의 크기
	static int getCnt; // 상어가 먹은 횟수
	static int result;
	
	static int[] dr = {0, -1, 0, 1}; // 가는 방향
	static int[] dc = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		sea = new int[n][n];
		size = 2;
		
		
		for (int i = 0; i < n; i++) { //-> 배열 초기화
			for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				sea[i][j] = tmp;
				if(tmp == 9) {
					r = i;
					c = j;
				}				
			}
		}
		
		
		while(check()) { // 먹이가 있는 동안 반복
			feeds = new ArrayList<>();
			
			visited = new boolean[n][n];
			bfs(r, c);			
			Collections.sort(feeds, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
			int[] tmp;
			if(feeds.size()>0){
				tmp = feeds.get(0);
			}else break;
			result += tmp[2];
			if(++getCnt==size) {
				size++;
				getCnt = 0;
			}			
			r = tmp[0];
			c = tmp[1];
			
			sea[r][c] = 0;
		}
		
		
		System.out.println(result);
	}
	
	static void bfs(int pr, int pc) {
		int min = 0;
		boolean checked = false;
		Queue<Shark> queue = new LinkedList<>();
		queue.offer(new Shark(r, c, size, 0));
		
		visited[r][c] = true;		
		sea[r][c] = 0;
		
		while(!queue.isEmpty()) {
			Shark s = queue.poll();
			if(sea[s.r][s.c] < size && sea[s.r][s.c] > 0) {
				if(checked == false) {
					min = s.cnt;
					checked = true;
				}
				if(min == s.cnt) feeds.add(new int[] {s.r, s.c, s.cnt});
			}
			for (int i = 0; i < 4; i++) {
				int nr = s.r + dr[i];
				int nc = s.c + dc[i];
				if(isCheck(nr, nc, s.size) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Shark(nr, nc, s.size, s.cnt+1));
				}
			}						
		}
	}
	
	
	//먹이가 있는지 파악
	static boolean check() {
		boolean isFlag = false;	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(size > sea[i][j] && sea[i][j] > 0) isFlag = true;
			}
		}		
		return isFlag;
	}
	
	//먹이를 
	
	static boolean isCheck(int nr, int nc, int size) {
		return (0<= nr && nr <n && 0<=nc && nc < n) && size >= sea[nr][nc]; 
	}

	
	static class Shark{
		int r;
		int c;
		int size;
		int cnt;
		public Shark(int r, int c, int size, int cnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.cnt = cnt;
		}
	}
}

/*
 * 
 * 맵에 더이상 먹을 수 있는 물고기가 없다면 종료
 * 1마리라면 그 물고기를 먹으러간다. -> bfs()사용
 * 1마리보다 많다면 거리가 가장 가까운 물고기를 먹으러 간다
 * 거리가 가까운 물고기가 많다면 가장 위쪽의 물고기, 가장 위쪽인 물고기가 많다면 왼쪽으로 가서 섭취를 시작한다. 
 * 자신과 같은 크기의 물고기를 먹을 경우 크기 1 증가
 * 
 * 자신보다 크기가 작은 물고기만 먹을 수 있으며, 같은 크기의 물고기는 먹을 수 없지만 먹을 수 있다.
 * 
 * 
 */