import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        fun(0);
        System.out.println(sb);
    }

    public static void fun(int cnt) {

        if (cnt == m) {
            for (int i=0; i<m; i++) {
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            selected[cnt] = arr[i];
            visited[i] = true;
            fun(cnt+1);
            visited[i] = false;
        }

    }
}
