import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start][end] =1;
			graph[end][start] =1;
		}
		
		visited = new boolean[N+1];
		
		List<Integer> list = new ArrayList<>();
		for(int i=2; i<=N; i++) {
			if(graph[1][i]!=0) {
				visited[i] = true;
				list.add(i);
			}
		}
		
		for(int x : list) {
			for(int i=2; i<=N; i++) {
				if(graph[x][i]!=0 && !visited[i]) visited[i]=true;
			}
		}
		
		int cnt =0;
		for(int i=2; i<=N; i++) {
			if(visited[i]) cnt+=1;
		}
		System.out.println(cnt);
	}
	
}