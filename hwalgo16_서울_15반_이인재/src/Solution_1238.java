import java.io.*;
import java.util.*;

public class Solution_1238 {
    static int T;
    static int l, s;
    static int size = 100;
    static boolean[][] fr;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/input.txt"));

        T = 10;

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            l = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            fr = new boolean[size+1][size+1];
            visited = new boolean[size+1];
            queue = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < l/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                fr[from][to] = true;
            }

            System.out.printf("#%d %d\n", t, bfs(s));
        }
    }

    private static int bfs(int x) {
        queue.offer(x);
        visited[x] = true;
        int result;
        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()){
            int tmp = queue.size();
            result = 0;
            for (int i = 0; i < tmp; i++) {
                int nx = queue.poll();
                for (int j = 1; j <= size; j++) {
                    if (fr[nx][j] && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                        result = Math.max(result, j);
                    }
                }
            }
            results.add(result);
        }
        return results.get(results.size()-2);
    }
}
