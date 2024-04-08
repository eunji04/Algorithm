import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] graph;
	static int[][] ans;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // graph 정렬 끝
		
		ans = new int[N][N];
		
		que = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j]!=0 && ans[i][j]==0) {
					ans[i][j] = 1;
					que.offer(j);
					bfs(i);
				}
				
			}
		}
		
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				System.out.print(ans[a][b]+" ");
			}
			System.out.println();
		}
		
	}

	static void bfs(int K) {
				
		while(!que.isEmpty()) {
			int n = que.poll();
			for(int j=0; j<N; j++) {
				if(graph[n][j]!=0 && ans[K][j]==0) {
					ans[K][j] = 1;
					que.offer(j);
				}
			}
			
		}
	}
	
}
