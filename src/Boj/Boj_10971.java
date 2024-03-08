package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {
    static int N;
    static int[][] city;
    static boolean[] visited;
    static int[] arr;
    static int ans;

    static void pick(int cnt){
        if(cnt ==N){
            int d =travel(arr);

            if(d ==-1) return;

            if(ans>d) ans =d;
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;

            arr[cnt] =i;
            visited[i] =true;
            pick(cnt+1);
            visited[i] =false;
        }
    }

    static int travel(int[] arr){

        int start =arr[0];
        int end =arr[N-1];
        int dis =0;
        boolean canGo =true;

        for(int i=0; i<N-1; i++){
            if(city[arr[i]][arr[i+1]]!=0) dis+=city[arr[i]][arr[i+1]];
            else {
                canGo =false;
                break;
            }
        }
        if(!canGo) return -1;
        if(city[end][start]!=0) {
            dis+=city[end][start];
            return dis;
        }
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        city =new int[N][N];
        StringTokenizer st =null;
        arr =new int[N];

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] =Integer.parseInt(st.nextToken());
            }
        } //city 세팅 끝

        ans =1000000*N+1;

        visited =new boolean[N];
        pick(0);

        System.out.println(ans);
    }
}