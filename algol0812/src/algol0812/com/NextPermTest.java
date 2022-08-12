package algol0812.com;

import java.util.Arrays;

public class NextPermTest {
		static int[] p = {1,2,3,4,5};
		static int n = p.length;
		static int count;			
		public static void main(String[] args) {
		
			do {
				count++;
				System.out.println(Arrays.toString(p));
			}while(np(n-1));
			System.out.println(count);			
		}
		private static boolean np(int size) {
			int i = size;
			while(i>0 && p[i-1] > p[i]) i--;
			if(i == 0)return false;
			int j = size;
			while(p[i-1] > p[j]) j--;
			int temp = p[i-1];
			p[i-1] = p[j];
			p[j] = temp;
			int k = size;
			while(i<k) {
				temp = p[i];
				p[i] = p[k];
				p[k] = temp;
				i++;
				k--;
			}
			return true;
		}		
}
