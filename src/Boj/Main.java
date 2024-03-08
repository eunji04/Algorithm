package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int x;
        int y;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, result, check;

    static int[][] grid;

    static int checkMaxi;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static List<Place> maxiList;

    static int maxNum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            grid = new int[N][N];

            maxiList = new ArrayList<>();

            checkMaxi = 0;

            check = 0;

            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j  < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());

                    if (grid[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
                        checkMaxi++;
                        maxiList.add(new Place(i, j));
                    }
                }
            }

            backtracking(0);

            System.out.println(result);

        }
    }

    public static void backtracking(int depth) {


        if (depth == checkMaxi) {

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == -1) {
                        cnt++;
                    }
                }
            }

            if (check >= maxNum) {

                if (maxNum == check) {
                    if (result > cnt) {
                        result = cnt;
                    }
                } else {
                    maxNum = check;
                    result = cnt;
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {

            // 연결
            if(connect(maxiList.get(depth), i, -1)) {
                check++;
                backtracking(depth + 1);
                check--;
                unConnect(maxiList.get(depth), i, 1);
            }
        }

        backtracking(depth + 1);

    }

    // canGo가 false 면 갈 수 있음
    public static boolean connect(Place maxiPlace, int dir, int p) {
        int nowX = maxiPlace.x;

        int nowY = maxiPlace.y;

        int cnt = 0;

        int nX = nowX + dx[dir];

        int nY = nowY + dy[dir];

        while (true) {

            if (0 <= nX && nX < N && 0 <= nY && nY < N) {


                if (grid[nY][nX] == 0) {
                    grid[nY][nX] += p;
                    cnt++;

                    nY += dy[dir];
                    nX += dx[dir];
                }

                else {

                    int uX = nowX;
                    int uY = nowY;

                    for (int i = 0; i < cnt; i++) {

                        uX += dx[dir];
                        uY += dy[dir];

                        grid[uY][uX] -= p;

                    }

                    return false;

                }


            } else {
                break;
            }

        }

        return true;
    }


    public static void unConnect(Place maxiPlace, int dir, int p) {
        int nowX = maxiPlace.x;

        int nowY = maxiPlace.y;

        int nX = nowX + dx[dir];

        int nY = nowY + dy[dir];

        int cnt = 0;

        while (true) {

            if (0 <= nX && nX < N && 0 <= nY && nY < N) {

                if (grid[nY][nX] < 0) {
                    grid[nY][nX] += p;

                    nY = nY + dy[dir];
                    nX = nX + dx[dir];
                } else {
                    break;
                }

            } else {
                break;
            }

        }

    }

}