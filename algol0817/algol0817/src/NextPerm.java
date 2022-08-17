import java.util.Arrays;

public class NextPerm {
    // n! 속도 엄청 느리다
    // 10! = 3628800
    static int[] p = {1, 2, 3, 4, 5, 6};
    static int n = p.length;
    static int count;

    public static void main(String[] args) {
        do {
            count++;
            System.out.println(Arrays.toString(p));
        }while(np(n-1));
        System.out.println(count);
    }

    private static boolean np(int size) {
        int i = size;
        while(i>0 && p[i] < p[i-1]) i--;
        if(i == 0) return false;
        int j = size;
        while (p[i-1] > p[j]) j--;

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
