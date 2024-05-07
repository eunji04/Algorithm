import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] people;

    static int[][] grid;

    static boolean[] visited, visited2;

    static List<Integer> AList, BList;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];

        grid = new int[N+1][N+1];

        visited = new boolean[N + 1];

        result = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                grid[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }

        makePowerset(1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);

    }

    public static void makePowerset(int depth) {

        if (depth == N + 1) {

            AList = new ArrayList<>();
            BList = new ArrayList<>();

            for (int i = 1; i < depth; i++) {
                if (visited[i]) {
                    AList.add(i);
                } else {
                    BList.add(i);
                }
            }

            if (AList.size() != 0 && BList.size() != 0) {
                if (inList(AList.get(0), AList) && inList(BList.get(0), BList)) {
                    int aPeople = 0;
                    int bPeople = 0;

                    for (int i = 0; i < AList.size(); i++) {
                        aPeople += people[AList.get(i)];
                    }

                    for (int i = 0; i < BList.size(); i++) {
                        bPeople += people[BList.get(i)];
                    }

                    if (Math.abs(aPeople - bPeople) < result) {
                        result = Math.abs(aPeople - bPeople);
                    }

                }
            }

            return;
        }

        visited[depth] = true;
        makePowerset(depth + 1);
        visited[depth] = false;
        makePowerset(depth + 1);
    }

    public static boolean inList(int start, List<Integer> list) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited2 = new boolean[N + 1];

        queue.add(start);

        visited2[start] = true;

        while (!queue.isEmpty()) {

            int now = queue.pollFirst();

            for (int i = 1; i <= N; i++) {
                if (grid[now][i] == 1 && !visited2[i]) {

                    boolean flag = false;

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) == i) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        queue.add(i);
                        visited2[i] = true;
                    }

                }
            }
        }

        boolean flag = true;

        for (int i = 0; i < list.size(); i++) {
            if (!visited2[list.get(i)]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
