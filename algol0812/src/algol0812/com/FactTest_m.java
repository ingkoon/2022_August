package algol0812.com;

import java.util.Arrays;

public class FactTest_m {
	static int[] fact = new int[13];
	
	//관계식을 끌어내는 DP의 기본
	public static void main(String[] args) {		
		Arrays.fill(fact, -1);
		fact[0] = 1;		
		for (int i = 1; i < 13; i++) {
			fact[i] = i  * fact[i-1];
		}
		for(int f: fact) {
			System.out.println(f);
		}
	}
}
