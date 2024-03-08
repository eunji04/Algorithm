package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1767 {

    static int N;
    static int[][] grid;

    static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x =x; this.y =y;
        }
    }

    static List<Pair> list;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T =Integer.parseInt(br.readLine());
        for(int tc =1; tc<=T; tc++){

            N =Integer.parseInt(br.readLine());
            grid =new int[N][N];
            list =new ArrayList<>();

            num =0;
            for(int i=0; i<N; i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    grid[i][j] =Integer.parseInt(st.nextToken());
                    if(grid[i][j] ==1){
                        if(i==0 || j==0 || i==N-1 || j==N-1) continue;
                        list.add(new Pair(i,j));
                        num+=1;
                    }
                }
            }

            core(0);
            System.out.printf("#%d %d\n",tc,ans);

        }
    }

    static int[] dx =new int[]{-1,1,0,0}; //샹하좌우
    static int[] dy =new int[]{0,0,-1,1};
    static int max, check, ans;
    static void core(int depth){
        if(depth ==num){
            int sum =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(grid[i][j]==-1) sum+=1;
                }
            }

            if(check>=max){
                if(check ==max){
                    if(ans>sum) ans =sum;
                } else{
                    max =check;
                    ans =sum;
                }
            }
            return;
        }

        for(int k=0; k<4; k++){

            if(corePowerOn(list.get(depth), k, -1)){
                check+=1;
                core(depth+1);
                check-=1;
                corePowerOff(list.get(depth), k, +1);
            }

        }

    }

    static boolean corePowerOn(Pair now, int d, int p){
        int nx =now.x+dx[d];
        int ny =now.y+dy[d];

        int cnt=0;
        while (true){

            if(nx>=0 && ny>=0 && nx<N && ny<N){

                if(grid[nx][ny] ==0){
                    cnt+=1;
                    grid[nx][ny]+=p;

                    nx +=dx[d]; ny+=dy[d];
                } else{
                    nx =now.x;
                    ny =now.y;

                    for(int k=0; k<cnt; k++){
                        nx+=dx[d]; ny+=dy[d];
                        grid[nx][ny]-=p;
                    }
                    return false;
                }

            } else break;

        }

        return true;
    }

    static void corePowerOff(Pair now, int d, int p){
        int nx =now.x+dx[d];
        int ny =now.y+dy[d];

        while (nx>=0 && ny>=0 && nx<N && ny<N){
            if(grid[nx][ny]<0){
                grid[nx][ny] +=p;
                nx+=dx[d]; ny+=dy[d];
            } else break;
        }
    }
}