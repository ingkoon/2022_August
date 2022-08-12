package algol0812.com;

import java.util.Arrays;

public class PhivoTest_m {
	
	static int[] pivo = new int[47];
	public static void main(String[] args) {
		
		Arrays.fill(pivo, -1);
		pivo[0] = 0;
		pivo[1] = 1;		
		for (int i = 0; i < 30; i++) {
			System.out.println(pivo(i));
		}
	}

	private static int pivo(int n) {
		
		if(pivo[n] != -1) return pivo[n];
		
		else return pivo(n-1) + pivo(n-2);
	}

}
