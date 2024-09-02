import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[m];

        fun(1, 0);

        System.out.println(sb);
    }

    public static void fun(int start, int cnt) {

        if (cnt == m) {
            for (int i=0; i<m; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<=n; i++) {
            arr[cnt] = i;
            fun(i, cnt+1);
        }

    }
}
