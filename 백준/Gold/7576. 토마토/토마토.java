import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int[][] arr;
    static int[][] visited;
    static Queue<Pair> que;

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static boolean inRange(int x, int y) {
        if (x<0 || y<0 || x>=m || y>=n) return false;
        return true;
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x,y)) return false;
        if (arr[x][y] != 0) return false;
        if (visited[x][y] != 0) return false;
        return true;
    }

    public static void bfs() {

        while(!que.isEmpty()) {
            Pair p = que.poll();
            int x = p.x;
            int y = p.y;

            for (int i=0; i<4; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];

                if (!canGo(newX, newY)) continue;

                visited[newX][newY] = visited[x][y] +1;
                que.offer(new Pair(newX, newY));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cnt = 0;

        arr = new int[m][n];
        visited = new int[m][n];
        que = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    visited[i][j] = 1;
                    que.offer(new Pair(i,j));
                    cnt +=1;
                } else if (arr[i][j] == -1) {
                    visited[i][j] = -1;
                    cnt+=1;
                }
            }
        }

        if (cnt == m*n) {
            System.out.println(0);
            return;
        }

        bfs();

        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] > 0) {
                    if (visited[i][j] > ans) ans = visited[i][j];
                } else if (visited[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans-1);

    }
}
