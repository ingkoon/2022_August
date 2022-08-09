import java.util.Arrays;

public class CombiTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;
    static int r;
    static int[] nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        r = 3;

        visited = new boolean[n];
        npr(0, 0, new int[r]);
        System.out.println(count);
    }

    private static void npr(int start, int cnt, int[] nums) {
        if(cnt == r) {  //base condition
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = start; i < n; i++) {
//            if(visited[i]) continue;
//            visited[i] = true;
            nums[cnt] = p[i];
            npr(i + 1, cnt+1, nums);
//            visited[i] = false;
            nums[cnt] = 0;
        }
    }
}
