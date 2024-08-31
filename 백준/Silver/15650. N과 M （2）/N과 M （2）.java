import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        fun(0, 1);
    }
    public static void fun(int cnt, int start) {
        if (cnt == m) {
            for (int i=0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i=start; i<=n; i++) {
            arr[cnt] = i;
            fun(cnt + 1, i+1);
        }
    }
}
