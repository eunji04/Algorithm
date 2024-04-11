import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static boolean[] know;
	static ArrayList<Integer>[] party;
	static Queue<Integer> que;
	static boolean[] visited;
	
	static int no;
	
	static void bfs(int n) {
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			for(int k=0; k<M; k++) {
				
				int yes = 0;
				for(int i=0; i<party[k].size(); i++) {
					if(num == party[k].get(i)) yes+=1;
				}
				
				if(yes == 0) continue;
				
				for(int i=0; i<party[k].size(); i++) {
					if(!visited[party[k].get(i)]) {
						visited[party[k].get(i)] = true;
						que.offer(party[k].get(i));
					}
				}
				
			}
			
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i] && know[i]) {
				cnt+=1;
			}
		}
		
		if(cnt!=0) {
			for(int i=1; i<=N; i++) {
				if(visited[i] && !know[i]) {
					know[i] = true;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		know = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			know[Integer.parseInt(st.nextToken())] = true;
		}
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int k=0; k<num; k++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		} // party 다 저장
		
		que = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			que.offer(i);
			bfs(i);
		}
		
		int ans =0;
		for(int k=0; k<M; k++) {
			int cnt =0;
			for(int i=0; i<party[k].size(); i++) {
				if(know[party[k].get(i)]) cnt+=1;
			}
			if(cnt==0) ans+=1;
		}
		System.out.println(ans);

	}
	
}
