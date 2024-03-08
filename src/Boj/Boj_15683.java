package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683 {

    static int N,M;
    static int[][] grid;
    static int[] dx =new int[]{-1,0,1,0}; //위 오 아 왼
    static int[] dy =new int[]{0,1,0,-1};

    static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x =x; this.y =y;
        }
    }

    static int ans;
    static void cctv(int depth){
        int cnt =0;
        if(depth ==num){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(grid[i][j]==0) cnt+=1;
                }
            }
            if(cnt<ans){
                ans =cnt;
            }
            return;
        }

        int[] dir =cctvMode(grid[list.get(depth).x][list.get(depth).y]);
        for(int k=0; k<4; k++){

            for(int i=0; i<dir.length; i++){
                cctvPower(list.get(depth), (dir[i]+k)%4, -1);
            }
            cctv(depth+1);
            for(int i=0; i<dir.length; i++){
                cctvPower(list.get(depth), (dir[i]+k)%4, +1);
            }

        }

    }

    static void cctvPower(Pair now, int d, int p){
        int nx =now.x +dx[d];
        int ny =now.y +dy[d];

        while(0<=nx && nx<N && 0<=ny && ny<M){
            if(grid[nx][ny] ==6) break;

            if(grid[nx][ny] <1){
                grid[nx][ny]+=p;
            }

            nx+=dx[d]; ny+=dy[d];
        }
    }

    static int[] cctvMode(int mode){
        if(mode ==1) return new int[]{1};
        else if(mode ==2) return new int[]{1,3};
        else if(mode ==3) return new int[]{0,1};
        else if(mode ==4) return new int[]{0,1,3};
        return new int[]{0,1,2,3};
    }

    static List<Pair> list;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        grid =new int[N][M];
        list =new ArrayList<>();

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] =Integer.parseInt(st.nextToken());
                if(1<=grid[i][j] && grid[i][j]<=5){
                    list.add(new Pair(i,j));
                    num+=1;
                }
            }
        } //cctv 세팅 끝

        ans =N*M;
        cctv(0);
        System.out.println(ans);
    }
}
