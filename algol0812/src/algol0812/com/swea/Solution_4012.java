package algol0812.com.swea;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution_4012 {

	static int T;
	static int n;
	static int[][] s;

	static List<Integer> synergy;
	static int result;
	
	static Map<Point, Integer> map;
	
	public static void main(String[] args) throws IOException{		
		Scanner sc = new Scanner(new FileReader("C:\\ssafy\\workspace\\2022_august\\algol0812\\src\\algol0812\\com\\swea\\sample_input.txt"));
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n= sc.nextInt();
			s = new int[n][n];
			synergy = new ArrayList<>();
			map = new HashMap<>();
			result = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					s[i][j] = sc.nextInt();
				}
			}	
			
			for (int i =0; i < n; i++) {
				for (int j = i; j < n; j++) {
					set(i, j);
				}
			}
			
		
			solve(0, 0, 0);
			System.out.printf("#%d %d\n", t, result);
		}
	
	}
	
	public static void set(int i, int j) {
		if(i == j) return;
		int val = s[i][j] + s[j][i];
		map.put(new Point(i, j), val);
	}
	
	public static void solve(int cnt, int start, int val) {
		if(cnt == 2){
			result = Math.min(result,val);
			return;
		}		
	
		for (int i = start; i < map.size(); i++) {
			val = Math.abs(val - map.get(i));
			solve(cnt+1, i+1, val);
		}
	}
}

/*
 * 모든 시너지의 수를 구한다.
 * 시너지의 합을 구한 다음 최소값끼리의 값을 구한다.
 * 
 */