import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,K;
    static int[] visited;

    static boolean inRange(int x){
        if(x<0 || x>=100000+1) return false;
        else return true;
    }
    static Queue<Integer> que;
    static void bfs(){

        while (!que.isEmpty()){
            int x =que.poll();

            int x3 =2*x;
            if(inRange(x3)) {

                if(visited[x3]!=0 && visited[x3]<=visited[x]) { }
                else{
                    visited[x3] =visited[x];
                    que.offer(x3);
                }
            }

            int x1 =x-1;
            if(inRange(x1)) {
                if(visited[x1]!=0 && visited[x1]<=visited[x]+1) { }
                else{
                    visited[x1] =visited[x]+1;
                    que.offer(x1);
                }
            }

            int x2 =x+1;
            if(inRange(x2)) {
                if(visited[x2]!=0 && visited[x2]<=visited[x]+1) { }
                else{
                    visited[x2] =visited[x]+1;
                    que.offer(x2);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        N =sc.nextInt();
        K =sc.nextInt();
        que =new ArrayDeque<>();

        visited =new int[100000+1];
        visited[N] =1;
        que.offer(N);
        bfs();
        System.out.println(visited[K]-1);
    }
}