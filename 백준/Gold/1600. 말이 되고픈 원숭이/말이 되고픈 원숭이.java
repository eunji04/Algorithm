import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K,W,H;
    static int[][] grid;
    static int[][][] visited;

    static class Pair{
        int x,y,z;
        public Pair(int x, int y, int z){
            this.x =x;
            this.y =y;
            this.z =z;
        }
    }

    static Queue<Pair> que;

    public static boolean inRange(int x, int y, int z){
        if(x<0 || y<0 || z<0 || x>=H || y>=W || z>K) return false;
        else return true;
    }

    static int[] horseX =new int[]{-1,-2,-2,-1,1,2,2,1};
    static int[] horseY =new int[]{-2,-1,1,2,2,1,-1,-2};
    static int[] monkeyX =new int[]{-1,1,0,0};
    static int[] monkeyY =new int[]{0,0,-1,1};

    public static void bfs(){

        while (!que.isEmpty()){
            Pair p =que.poll();
            int x=p.x; int y=p.y; int z=p.z;

            for(int k=0; k<8; k++){
                int newX =x+horseX[k];
                int newY =y+horseY[k];
                int newZ =z+1;
                if(!inRange(newX,newY,newZ)) continue;
                if(grid[newX][newY]==1) continue;
                if(visited[newX][newY][newZ]!=0 && visited[newX][newY][newZ]<=visited[x][y][z]+1) continue;

                visited[newX][newY][newZ] =visited[x][y][z]+1;
                que.offer(new Pair(newX,newY,newZ));
            }

            for(int k=0; k<4; k++){
                int newX =x+monkeyX[k];
                int newY =y+monkeyY[k];
                int newZ =z;
                if(!inRange(newX,newY,newZ)) continue;
                if(grid[newX][newY]==1) continue;
                if(visited[newX][newY][newZ]!=0 && visited[newX][newY][newZ]<=visited[x][y][z]+1) continue;

                visited[newX][newY][newZ] =visited[x][y][z]+1;
                que.offer(new Pair(newX,newY,newZ));
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        K =Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        W =Integer.parseInt(st.nextToken());
        H =Integer.parseInt(st.nextToken());
        grid =new int[H][W];
        visited =new int[H][W][K+1];

        for(int i=0; i<H; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                grid[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        //grid 세팅 끝

        que =new ArrayDeque<>();
        visited[0][0][0] =1;
        que.offer(new Pair(0,0,0));

        bfs();
//        for(int h=0; h<=K; h++){
//            for(int i=0; i<H; i++){
//                for(int j=0; j<W; j++){
//                    System.out.print(visited[i][j][h]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int result =Integer.MAX_VALUE;
        for(int h=0; h<=K; h++){
            if(visited[H-1][W-1][h] ==0) continue;
            if(visited[H-1][W-1][h]<result) result=visited[H-1][W-1][h];
        }

        if(result!=Integer.MAX_VALUE) System.out.println(result-1);
        else System.out.println(-1);
    }

}