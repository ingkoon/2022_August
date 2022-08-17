import java.util.ArrayList;
import java.util.Arrays;

public class SubsetTest {
    static int[] p = {1,2,3,4,5,6};
    static int n = p.length;
    static int r;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) {
        r = 3;
        visited= new boolean[n];
        npr(0, 0, new ArrayList<String>());
        System.out.println(count);
    }

    private static void npr(int cnt, int tot, ArrayList<String> nums) {
        if(cnt == n){
            count++;
            System.out.println(Arrays.toString(nums.toArray()));
            for (int i = 0; i < n; i++) {
                if(visited[i])
                    System.out.print(p[i]+" ");
            }
            System.out.println();
            System.out.println("------------->" + tot);
            return;
        }
            visited[cnt] = true;
            nums.add(p[cnt]+"");
            npr(cnt+1, tot+p[cnt], nums);
            visited[cnt] = false;
            nums.remove(p[cnt]+"");
            npr(cnt+1, tot, nums);
    }
}
