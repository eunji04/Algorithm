import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx =new int[]{-1,1,0,0};
    static int[] dy =new int[]{0,0,-1,1};
    static boolean inRange(int x, int y){
        if(x<0 || y<0 || x>=N || y>=M) return false;
        return true;
    }

    static class Pair{
        int x; int y;
        public Pair(int x, int y){
            this.x =x;
            this.y =y;
        }
    }

    static Queue<Pair> que =new ArrayDeque<>();

    static boolean melting(){

        visited =new boolean[N][M];
        int ice_cnt =que.size();
        if(ice_cnt==0) {
            return false;
        }

        while (ice_cnt-->0){
            Pair p =que.poll();
            int x =p.x;
            int y =p.y;
            int cnt =0;
            for(int k=0; k<4; k++){
                int newX =x+dx[k];
                int newY =y+dy[k];
                if(!inRange(newX,newY)) continue;
                if(arr[newX][newY]==0 && !visited[newX][newY]){
                    cnt+=1;
                }
            }
            arr[x][y]-=cnt;
            if(arr[x][y]<=0){
                visited[x][y] =true;
                arr[x][y] =0;
            } else{
                que.offer(new Pair(x,y));
            }
        }
        return true;
    }

    static Queue<Pair> go;
    static boolean[][] check;
    static int cnt;
    static void canGo(){

        while (!go.isEmpty()){
            Pair p =go.poll();
            int x =p.x;
            int y =p.y;
            for(int k=0; k<4; k++){
                int newX =x+dx[k];
                int newY =y+dy[k];
                if(inRange(newX,newY) && arr[newX][newY]!=0 && !check[newX][newY]){
                    go.offer(new Pair(newX,newY));
                    check[newX][newY] =true;
                }
            }
        }
        cnt+=1;
    }

    static void fun(){
        cnt=0;
        check =new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]!=0 && !check[i][j]){
                    go.offer(new Pair(i,j));
                    check[i][j] =true;
                    canGo();
                    if(cnt>1) return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        arr =new int[N][M];
        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0) que.offer(new Pair(i,j));
            }
        }

        go =new ArrayDeque<>();
        int time =0;

        while (true){
            if(!melting()) {
                time =0;
                break;
            }
            time+=1;
            fun();

            if(cnt>1) break;
        }

        System.out.println(time);

    }

}
