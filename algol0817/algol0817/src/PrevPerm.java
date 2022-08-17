import java.util.Arrays;

public class PrevPerm {
    // n! 속도 엄청 느리다
    // 10! = 3628800
    static int[] p = {6, 5, 4, 3, 2, 1};
    static int n = p.length;
    static int count;

    public static void main(String[] args) {
        do {
            count++;
            System.out.println(Arrays.toString(p));
        }while(pp(n-1));
        System.out.println(count);
    }

    private static boolean pp(int size) {
        int i = size;
        while(i>0 && p[i] > p[i-1]) i--;
        if(i == 0) return false;
        int j = size;
        while (p[i-1] < p[j]) j--;

        int tmp = p[i-1];
        p[i-1] = p[j];
        p[j] = tmp;
        int k = size;
        while (i<k){
            tmp = p[i];
            p[i] = p[k];
            p[k] = tmp;
            i++;
            k--;
        }
        return true;
    }
}
