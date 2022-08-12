package algol0812.com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
	static int n;
	static int k;
	static int[] map;
	
	static int SIZE = 100000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[SIZE+1];	
		bfs(n);
		System.out.println(map[k]-1);
	}
	
	public static void bfs(int loc) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(loc);
		map[loc] = 1;
		while(map[k] == 0) {
			
			int tmp = queue.poll();
			
			if(tmp-1 >= 0 && map[tmp - 1] == 0) {
				map[tmp-1] = map[tmp]+1;
				queue.add(tmp-1);
				}
		
			if( tmp + 1 <=SIZE && map[tmp + 1] == 0) {
				map[tmp+1] = map[tmp]+1; 
				queue.add(tmp+1);
			}
			if( tmp*2 <=SIZE && map[tmp * 2] == 0 ){
				map[tmp*2] = map[tmp]+1;
				queue.add(tmp*2);
			}		
			
		}
	}

}
