package algol0812.com;

import java.util.Arrays;

public class PhivoTest_t {
	
	static int[] pivo = new int[47];
	public static void main(String[] args) {
		
		Arrays.fill(pivo, -1);
		pivo[0] = 0;
		pivo[1] = 1;	
		
		for (int i = 2; i < 47; i++) {
			pivo[i] = pivo[i-1] + pivo[i-2];
		}
		for (int i = 0; i < 47; i++) {
			System.out.println(pivo[i]);
		}
	}
}
