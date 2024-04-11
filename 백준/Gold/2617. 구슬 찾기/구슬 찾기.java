import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,mid;
	static int[][] graph;
	static boolean[] visited;
	static Queue<Integer> que;
	static int ans;
	
	static void bfsMin(int n) {
		
		while(!que.isEmpty()) {
			
			int num = que.poll();
			for(int j=1; j<=N; j++) {
				if(graph[num][j]==-1 && !visited[j]) {
					visited[j] = true;
					que.offer(j);
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) cnt+=1;
		}
		
		if(cnt>mid) ans+=1;
		
	}
	
	static void bfsMax(int n) {
		
		while(!que.isEmpty()) {
			
			int num = que.poll();
			for(int j=1; j<=N; j++) {
				if(graph[num][j]==1 && !visited[j]) {
					visited[j] = true;
					que.offer(j);
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) cnt+=1;
		}
		
		if(cnt>mid) ans+=1;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mid = (N+1)/2;
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1; //a>b 무거울 때 1
			graph[b][a] = -1; //b<a 가벼울 때 -1
		}
		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		que = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			que.offer(i);
			bfsMin(i);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			que.offer(i);
			bfsMax(i);
		}
		
		System.out.println(ans);
	}

}
