import java.util.Arrays;

public class CombiTest {
    static int[] p = {1,2,3,4,5,6};
    static int n = p.length;
    static int r;
    static int[] nums;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) {
        r = 3;
        nums = new int[r];
        npr(0, 0);
        System.out.println(count);
    }

    private static void npr(int cnt, int size) {
        if(cnt == r){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = size; i < n; i++) {
            nums[cnt] = p[i];
            npr(cnt+1, i+1);
        }
    }
}
