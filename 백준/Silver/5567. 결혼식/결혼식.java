import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, cnt;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start][end] =1;
			arr[end][start] =1;
		}
		
		visited[1] = true;
		
		Queue<Integer> que = new ArrayDeque<>();
		for(int j=1; j<=N; j++) {
			if(arr[1][j]!=0) {
				visited[j] = true;
				que.offer(j);
			}
		}
		
		while(!que.isEmpty()) {
			int n = que.poll();
			check(n);
		}
		
		for(int i=2; i<=N; i++) {
			if(visited[i]) cnt+=1;
		}
		System.out.println(cnt);
		
	}
	
	static void check(int n) {
		
		for(int j=1; j<=N; j++) {
			if(arr[n][j]!=0 && !visited[j]) {
				visited[j] = true; 
			}
		}
		
	}
	
}