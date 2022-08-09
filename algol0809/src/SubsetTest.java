import java.util.Arrays;

public class SubsetTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {

        visited = new boolean[n];
        npr(0, 0);
        System.out.println(count);
    }

    private static void npr(int cnt, int tot) {
        if(cnt == n) {  //base condition
            count++;
            for (int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(p[i] + " ");
            }
            System.out.println();
            System.out.println("-------------------------");
            return;
        }

        visited[cnt] = true;
        npr(cnt+1, tot + p[cnt]);
        visited[cnt] = false;
        npr(cnt + 1, tot);
    }
}
