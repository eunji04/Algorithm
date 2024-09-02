import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        fun(0);
        System.out.println(sb);
    }

    private static void fun(int cnt) {
        if (cnt == m) {
            for (int i=0; i<m; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            arr[cnt] = i;
            fun(cnt + 1);
        }
    }

}
