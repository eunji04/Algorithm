import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] rotto;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            rotto = new int[6];
            arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            fun(0, 0);
            System.out.println();

        }

    }

    static void fun(int start, int cnt) {

        if (cnt == 6) {
            for (int i=0; i<6; i++) {
                System.out.print(rotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=start; i<n; i++) {
            rotto[cnt] = arr[i];
            fun(i+1, cnt+1);
        }

    }

}
