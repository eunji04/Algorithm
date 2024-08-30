import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fun(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);

    }

    static void fun(int x, int y, int k) {

        int n = arr[x][y];

        if (k==1) {
            cnt[n+1]++;
            return;
        }

        for (int i=x; i<x+k; i++) {
            for (int j=y; j<y+k; j++) {
                if (arr[i][j] != n) {
                    int len = k/3;
                    fun(x, y, len);
                    fun(x, y+len, len);
                    fun(x, y+2*len, len);
                    fun(x+len, y, len);
                    fun(x+len, y+len, len);
                    fun(x+len, y+2*len, len);
                    fun(x+2*len, y, len);
                    fun(x+2*len, y+len, len);
                    fun(x+2*len, y+2*len, len);
                    return;
                }
            }
        }

        cnt[n+1]++;

    }

}
