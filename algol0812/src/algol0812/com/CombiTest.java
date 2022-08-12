package algol0812.com;

import java.util.Arrays;

public class CombiTest {
		static int[] p = {1,2,3,4,5};
		static int n = p.length;
		static int r;
		static int count;		
		static boolean[] visited;
		public static void main(String[] args) {
			r = 3;
			visited = new boolean[n];
			nCr(0, 0,new int[r]);
			System.out.println(count);
			
		}
		// recursion -> fact -> pivo -> nCr -> fact t
		private static void nCr(int cnt,int start,int[] nums) {
			if(cnt == r) {
				count++;
				System.out.println(Arrays.toString(nums));
				return;
			}
			for (int i = start; i < n; i++) {
				
				visited[i] = true;
				nums[cnt] = p[i];
				nCr(cnt +1, i+1,nums);
				visited[i] = false;
				nums[cnt] = 0;
			}
		}
}
