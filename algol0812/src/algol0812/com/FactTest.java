package algol0812.com;

public class FactTest {
	public static void main(String[] args) {
		for (int i = 0; i < 13; i++) {
			System.out.println(fact(i));
		}
	}

	// f(5) = 5 * f(4) -> callstack(stack) dfs
	// recursiuon -> end condition -> dfs -> dfs + 저장 + 원위치 + prunning(btr)
	private static int fact(int n) {
		if(n <= 1) return n;
		
		return n * (fact(n-1));
	}
}
