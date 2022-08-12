package algol0812.com;

import java.util.Arrays;

public class PermTest2 {
		static int[] p = {1,2,3,4,5};
		static int n = p.length;
		static int r;
		static int count;		
		public static void main(String[] args) {
			r = 3;
			npr(0, 0,new int[r]);
			System.out.println(count);
			
		}
		// recursion -> fact -> pivo -> nCr -> fact t
		private static void npr(int cnt, int flag, int[] nums) {
			if(cnt == r) {
				count++;
				System.out.println(Arrays.toString(nums));
				return;
			}
			for (int i = 0; i < n; i++) {
				if((flag & (1<<i))!=0) continue;
				nums[cnt] = p[i];
				npr(cnt +1,(flag | (1<<i)),  nums);
				nums[cnt] = 0;
			}
		}
}
