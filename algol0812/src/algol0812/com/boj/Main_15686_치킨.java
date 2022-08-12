package algol0812.com.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15686_치킨 {
	static class L{
		int r;
		int c;
		public L(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public L() {
		}
	}
	
	static int N,R;
	static int [][] map;
	static int []nums;
	static int [][] dist; 
	static int mindistance;
	static ArrayList<L> chickens;
	static ArrayList<L> homes;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		dist=new int[14][101];  // [chick][home]
		N=scann.nextInt();
		R=scann.nextInt();
		map=new int[N][N];
		chickens=new ArrayList<>();
		homes=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==1){
					homes.add(new L(i,j));
				}else if(map[i][j]==2){
					chickens.add(new L(i,j));
				}
			}
		} 
		
		nums=new int[R]; // M개 선택된 치킨집 번호=>  모든 치킨CM
		
		mindistance = Integer.MAX_VALUE;// 거리들의합중 최소값
		nCr(0,0);
		System.out.println(mindistance);
	}
	public static void nCr(int start, int cnt) {
		if(cnt==R){
			// select 에 치킨집들이 들어옴
			//로직을 넣어서 구하자.
			return;
		}
		
		for (int i = start; i < chickens.size() ; i++) {
			nums[cnt]=i;
			nCr(i+1, cnt+1);
		}
	}
	static int cal(L l1, L l2){
		return Math.abs(l1.r-l2.r)+Math.abs(l1.c-l2.c);
	}
}
