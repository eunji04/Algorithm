import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] grid;
	
	static int[][] distance;
	static boolean[][] visited;
	
	static int[] dx = new int[] {0,1,0,-1}; // 오른쪽, 아래
	static int[] dy = new int[] {1,0,-1,0};
	
	static boolean inRange(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		else return true;
	}
	
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Queue<Pair> que;
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			
			Pair p = que.poll();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int newX = x+dx[k];
				int newY = y+dy[k];
				
				if(!inRange(newX,newY)) continue;
				
				if(!visited[newX][newY]) {
					distance[newX][newY] = distance[x][y] + grid[newX][newY];
					que.offer(new Pair(newX,newY));
					visited[newX][newY] = true;
				} else {
					
					if(distance[newX][newY] <= distance[x][y]+grid[newX][newY]) continue;
					else {
						distance[newX][newY] = distance[x][y] + grid[newX][newY];
						que.offer(new Pair(newX,newY));
					}

				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc =0;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N ==0) break;
			
			grid = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			
			StringTokenizer st = null;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//grid 세팅 끝
			
			que = new ArrayDeque<>();
			que.offer(new Pair(0,0));
			distance[0][0] = grid[0][0];
			visited[0][0] = true;
			
			bfs();
			tc+=1;
			
			System.out.println("Problem "+tc+": "+distance[N-1][N-1]);
			
		}
		
	}

}
