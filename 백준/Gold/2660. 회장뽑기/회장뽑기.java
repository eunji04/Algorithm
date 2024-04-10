import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] graph;
	static int[] score;
			
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		score = new int[N+1];
		
		int max = 251;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				graph[i][j] = max;
			}
		}
				
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1) break;
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					
				}
			}	
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			
			int m = 0;
			for(int j=1; j<=N; j++) {
				m = Math.max(m, graph[i][j]);
			}
			
			score[i] = m;
			min = Math.min(min, m);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			if(score[i] == min) {
				list.add(i);
			}
		}
		
		System.out.println(min+" "+list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
}
