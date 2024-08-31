import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] selected;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        selected = new boolean[n];

        fun(0);
    }
    public static void fun(int cnt) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!selected[i]) {
                arr[cnt] = i+1;
                selected[i] = true;
                fun(cnt+1);
                selected[i] = false;
            }
        }
    }
}
