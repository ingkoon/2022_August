package algol0826.com.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236 {
	static int n;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};	//cw
	
	static class Shark{
		int r;
		int c;
		int size = 2;
		int eat = 0;
		int time = 0;
		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		void eat() {
			this.eat++;
			if(eat==size) {
				this.eat=0;
				this.size++;
			}
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int distance; //거리를 구하고 pq에 넣는다.
		
		public Fish(int r, int c, int size, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}
		
		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
		
		public Fish(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Fish o) {
			int dis = Integer.compare(this.distance, o.distance);
			if(dis!=0) {
				return dis;	//거리가 짧을 경우
			}else {
				int rs = Integer.compare(this.r, o.r);
				if(rs != 0) {
					return rs; // 가장 위		
				} else {
					return Integer.compare(this.c, o.c); // 가장 왼쪽 
				}
			}			
		}		
	}
	
	static Shark shark;
	static List<Fish> fishes;
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		fishes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					shark = new Shark(i, j);
				} else if(map[i][j] >= 1 && map[i][j] <=6) {
					fishes.add(new Fish(i, j, map[i][j]));
				}
			}
		} // 읽기
		//로직
		result = 0;		
		eating();
		result = shark.time;
		System.out.println(result);
		
	}

	private static void eating() {	
		//모든 물고기에서 현재 상어가 먹을 수 있는 물고기 찾기
		List<Fish> edible = new ArrayList<Fish>();
		for (Fish f:fishes) {
			if(shark.size>f.size) {
				edible.add(f);
			}
		}
		if(edible.size() == 0) return; // 먹을 것이 없는 상태
		
		PriorityQueue<Fish> queue = new PriorityQueue<>();
		// 먹을 수 있는 물고기에 대하여 거리를 구하고, 가장 가까운 물고기를 먹자
		// 먹을 수 있는 물고기에 도달 못할 경우 -1 		
		// 먹을 수 있는 물고기를 가져온다. 그리고 상어에서 각 물고기에 대하여 거리를 구한다.
		for (int i = 0; i < edible.size(); i++) {
			Fish now = edible.get(i);
			// 상어와 물고기 사이의 거리 (상어기 물고기와 같거나 커야 통과)
			int distance = distance(shark.r, shark.c, now.r, now.c, shark.size);
			//먹을 수 있는 물고기일 경우 큐에 추가
			if(distance != -1) {
				now.distance = distance;
				queue.offer(now);
			}			
		}
		if(queue.size()==0) {
			return;
		}
		else {
			Fish f = queue.poll();
			map[shark.r][shark.c] = 0;
			shark.r = f.r;
			shark.c = f.c;
			shark.eat();			
			shark.time += f.distance;
			fishes.remove(f);
			map[shark.r][shark.c] = 0;
			eating();
		}			
	}

	private static int distance(int r1, int c1, int r2, int c2, int size) {
		Queue<int[]> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[n][n];
		q.offer(new int[] {r1, c1, 0});
		visited[r1][c1] = true;
		
		int result = -1;
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			int pr = loc[0];
			int pc = loc[1];			
			int dis = loc[2];
			if(pr == r2 && pc == c2) {
				result = dis;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if(!check(nr, nc) || visited[nr][nc] || map[nr][nc] > size) continue;
					visited[nr][nc] = true;
					result++;
					q.offer(new int[] {nr, nc, dis + 1});
			}
		}
		return result;
	}

	private static boolean check(int nr, int nc) {
		return 0<= nr && nr < n && 0 <= nc && nc < n;
	}
	
}
/*
*
* 
*/
