package algol0812.com;

import java.util.Arrays;

public class PermTest {
		static int[] p = {1,2,3,4,5};
		static int n = p.length;
		static int r;
		static int count;		
		static boolean[] visited;
		public static void main(String[] args) {
			r = 3;
			visited = new boolean[n];
			npr(0, new int[r]);
			System.out.println(count);
			
		}
		// recursion -> fact -> pivo -> nCr -> fact t
		private static void npr(int cnt, int[] nums) {
			if(cnt == r) {
				count++;
				System.out.println(Arrays.toString(nums));
				return;
			}
			for (int i = 0; i < n; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				nums[cnt] = p[i];
				npr(cnt +1, nums);
				visited[i] = false;
				nums[cnt] = 0;
			}
		}
}
