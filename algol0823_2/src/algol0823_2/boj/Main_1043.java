package algol0823_2.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1043 {
	static int n, m, people;
	static int[] nums;
	static int[] p;
	static int[][] party;
	
	static boolean[] visited;
	static int result;
	
	static List<int[]> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		people = sc.nextInt();	
		nums = new int[people];
		visited = new boolean[n+1];
		party = new int[n][];
		
		if(people>0) {
			for (int i = 0; i < people; i++) {
				int tmp = sc.nextInt();
				nums[i] = tmp;
				visited[tmp] = true;
			}				
		}
		
		makeSet();	
	
		//파티 정보 가져오기
		for (int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			party[i] = new int[tmp];
			for (int j = 0; j < tmp; j++) {
				party[i][j] = sc.nextInt();
			}
		}
			
		// 파티의 인원들을 union, 해당 그룹에 진실을 아는 사람이 있다면 
		// visited배열에 해당 번호 true 수행
		for(int[] pt : party) {
			if(pt.length>0) {
			for (int i = 0; i < pt.length-1; i++) {				
				union(pt[i], pt[i+1]);
				System.out.println(Arrays.toString(p));
				}
			}
			for(int tmp : p) {
				if(Arrays.asList(nums).contains(tmp)) visited[tmp] = true;
			}
			makeSet();
		}
		
		// 
		for(int[] pt : party) {
			boolean tmp = false;
			if(pt.length > 0) {
				for (int i = 1; i < pt.length; i++) {
					if(visited[pt[i]]) tmp = true;
					break;
				}
			}
			if(!tmp) result++;
		}
		
		System.out.println(result);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		if (p[x] > p[y]) {			
			p[x] = y;
		} else {			
			p[y] = x;
		}
	}
	
	private static int find(int x) {
		if(p[x] == x) return x;		
		return p[x] = find(p[x]);
	}
	
	private static boolean findL(int x) {		
		if(p[x] == x) return true;
		else if(Arrays.asList(nums).contains(x)) return false;
		else return findL(p[x]);
	}

	private static void makeSet() {
		p = new int[n+1];		
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}		
	}	
}
