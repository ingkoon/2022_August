package algol0812.com.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_15686 {
	static int n, m;
	static List<Chicken> chickens;
	static List<Home> homes;
	static int[][] map;
	static int[][] dist;
	static int[] selected;
	static int homeCnt;
	static int chickenCnt;
	
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		 
		 chickens = new ArrayList<>();
		 homes = new ArrayList<>();
		 
		 map = new int[n][n];
		 dist = new int[14][101];
		 selected = new int[14];
		 
		 homeCnt = 0;		 
		 chickenCnt = 0;
		 result = Integer.MAX_VALUE;
		 
		 for (int i = 0; i < n; i++) {
			 for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if(tmp == 2) {
					chickens.add(new Chicken( i, j));
				}
				else if(tmp == 1) homes.add(new Home(i, j));					
				map[i][j] = tmp;
			} 
		 }
		
		 for (int i = 0; i < chickens.size(); i++) {
			for (int j = 0; j < homes.size(); j++) {
				
				dist[i][j] = calcDistance(homes.get(j), chickens.get(i));
			}
		}		
		 
		 ncr(0,0);
		 System.out.println(result);
	}
	
	static void ncr(int cnt, int start) {
		if(cnt == m) {			
			result = Math.min(result, solve());
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			selected[cnt] = i;
			ncr(cnt+1, i+1);
		}
	}
	
	static int solve() {
		int res = 0;
		for (int i = 0; i < homes.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				min = Math.min(min, dist[selected[j]][i]);
			}
			res+=min;
		}
		return res;
	}
	
	// 치킨집의 거리 구하기
	static int calcDistance(Home h, Chicken c) {
		return Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
		
	}
	
	static class Chicken{
		int r, c;
		public Chicken( int r, int c) {
			this.r = r;
			this.c = c;			
		}
	}
	static class Home{
		int r, c;
		public Home( int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

/*
 * 집을 어레이 리스트에 넣고 반복을 돌리면서 
 * 각각의 치킨거리를 구한다. 
 * 
 * */
