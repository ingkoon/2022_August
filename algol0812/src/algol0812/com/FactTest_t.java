package algol0812.com;

import java.util.Arrays;

public class FactTest_t {
	static int[] fact = new int[13];
	
	public static void main(String[] args) {		
		Arrays.fill(fact, -1);
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 0; i < 13; i++) {
			System.out.println(fact(i));
		}
	}

	// f(5) = 5 * f(4) -> callstack(stack) dfs
	// recursiuon -> end condition -> dfs -> dfs + 저장 + 원위치 + prunning(btr)
	private static int fact(int n) {
		if(fact[n] != -1) return fact[n];
		
		return fact[n] = n * (fact(n-1));
	}
}
