package algol0826.com.boj;

public class Main_2098 {
	static int n;
	static int[][] dist;
	
	public static void main(String[] args) {
		
	}
	private static int tsp(int visited, int city) {
		//모든 도시 방문 여부
		if(visited == (1<<n) -1 ) {
			if(dist[city][0]==0) return Integer.MAX_VALUE / 100;
			return dist[city][0];
		}
		if(dist[visited][city] != -1){ // 방문 한적 있다.			
			return dist[visited][city];
		}
		for (int i = 0; i < n; i++) {
			if((visited & (1 <<i))!=0) continue;
			if(dist[city][i] == 0) continue;
			int result = tsp((visited | (1<<i)), i) + dist[city][i];
			dist[visited][city] = Math.min(result, dist[visited][city]);
		}
		
		return dist[visited][city];
	}

}
