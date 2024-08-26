import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;

    static class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pair> que;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //열
            N = Integer.parseInt(st.nextToken()); //행
            arr = new int[N][M];
            visited = new boolean[N][M];
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            que = new ArrayDeque<>();

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); //열
                int Y = Integer.parseInt(st.nextToken()); //행
                arr[Y][X] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        que.add(new Pair(i, j));
                        visited[i][j] = true;
                        bfs();
                        cnt+=1;
                    }
                }
            }

            System.out.println(cnt);

        }

    }

    static void bfs() {

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (inRange(newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    if (arr[newX][newY] == 1) {
                        que.offer(new Pair(newX, newY));
                    }
                }
            }
        }

    }

}
