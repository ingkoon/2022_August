package algol0826.com.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_17144 {
	static int r, c, T, cnt;
	static int[][] room;
	static int[] dr = {-1, 0 , 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Cleaner top, bottom;
	static int result;
	
	static class Cleaner{
		int r;
		int c;
		public Cleaner(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	static class Dust{
		int r;
		int c;
		int val;
		public Dust(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		T = sc.nextInt();	
		
		room = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] = sc.nextInt();
				if(room[i][j] == -1) {
					if(cnt == 0) {
						top = new Cleaner(i, j);
						cnt++;
					}
					else bottom = new Cleaner(i, j);
				}
			}
		}		
		
		// 시간 만큼 반복 수행
		for (int t = 0; t < T; t++) {
		
			// 먼지 확산
			List<Dust> dusts = new ArrayList<>(); 
			//모든 원소를 탐색하며 확산 실행
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(room[i][j] > 0) dusts.add(new Dust(i, j, room[i][j]));					
				}
			}
			
			List<Dust> newDust = diff(dusts);
			
			int[][] newRoom = new int[r][c];
						
			newRoom[top.r][top.c] = -1;
			newRoom[bottom.r][bottom.c] = -1;
			for (Dust d: newDust) {
				newRoom[d.r][d.c] += d.val;
			}		
			room = clear(newRoom);
		}
	
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += room[i][j];
			}
		}
		
		System.out.println(result + 2);
	}
	
	private static List<Dust> diff(List<Dust> dusts) {
		List<Dust> spreadDust = new ArrayList<>();
				
		for(Dust d : dusts) {		
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = d.r + dr[i];
				int nc = d.c + dc[i];
				if(check(nr, nc) && room[nr][nc] != -1) {
					spreadDust.add(new Dust(nr, nc, d.val/5));
					cnt ++;
				}
			}
			
			spreadDust.add(new Dust(d.r, d.c, d.val -  d.val/5 * cnt));
			
		}
		return spreadDust;		
	}
	
	private static int[][] clear(int[][] newRoom){
		int[] topDr = {0, -1, 0, 1};
		int[] bottomDr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		
		//위쪽 공기청정기
		int topR = top.r;
		int topC = top.c+1;
		int tmp = newRoom[topR][topC];
		
		for (int i = 0; i < 4; i++) {			
			while(check(topR+topDr[i], topC + dc[i]) && newRoom[topR][topC]!=-1) {
				int nr = topR + topDr[i];
				int nc = topC + dc[i];	 
				int tmp2 = newRoom[nr][nc];
				newRoom[nr][nc] = tmp;			
				tmp = tmp2;
				topR = nr;
				topC = nc;				
			}			
		}
		
		newRoom[top.r][top.c] = -1;
		newRoom[top.r][top.c+1] = 0;
				
		
		
		int bottomR = bottom.r;
		int bottomC = bottom.c+1;
		tmp = newRoom[bottomR][bottomC];	
		
		for (int i = 0; i < 4; i++) {			
			while(check(bottomR+bottomDr[i], bottomC + dc[i]) && newRoom[bottomR][bottomC]!=-1) {
				int nr = bottomR + bottomDr[i];
				int nc = bottomC + dc[i];
				int tmp2 = newRoom[nr][nc];
				newRoom[nr][nc] = tmp;						
				tmp = tmp2;
				bottomR = nr;
				bottomC = nc;		
			}			
		}
		newRoom[bottom.r][bottom.c] = -1;
		newRoom[bottom.r][bottom.c+1] = 0;
		return newRoom;		
	}
	
	static boolean check(int nr, int nc) {
		return 0<= nr && nr < r && 0 <= nc && nc < c;
	}
}
