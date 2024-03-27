import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] grid;
	static int[][][] visited;
	
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	static boolean inRange(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=M) return false;
		else return true;
	}
	
	static class Pair{
		int x; int y; int h;
		public Pair(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	static Queue<Pair> que;
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			Pair p = que.poll();
			
			int x = p.x;
			int y = p.y;
			int h = p.h;
			
			for(int k=0; k<4; k++) {
				int newX = x+dx[k];
				int newY = y+dy[k];
				if(!inRange(newX,newY)) continue;
				
				if(grid[newX][newY] ==0) {
					if(visited[h][newX][newY] ==0) {
						visited[h][newX][newY] = visited[h][x][y]+1;
						que.offer(new Pair(newX, newY, h));
					} else if(visited[h][newX][newY] > visited[h][x][y]+1) {
						visited[h][newX][newY] = visited[h][x][y]+1;
						que.offer(new Pair(newX, newY, h));
					}
				} else {
					if(h==1) continue;
					
					if(visited[h+1][newX][newY] ==0) {
						visited[h+1][newX][newY] = visited[h][x][y]+1;
						que.offer(new Pair(newX, newY, h+1));
					} else if(visited[h+1][newX][newY] > visited[h][x][y]+1) {
						visited[h+1][newX][newY] = visited[h][x][y]+1;
						que.offer(new Pair(newX, newY, h+1));
					}
					
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		visited = new int[2][N][M];
		que = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				grid[i][j] = s.charAt(j)-'0';
			}
		}
		
		visited[0][0][0] =1;
		que.offer(new Pair(0,0,0));
		bfs();
		
		int a = visited[0][N-1][M-1];
		int b = visited[1][N-1][M-1];
		
		if(a==0) {
			if(b==0) System.out.println(-1);
			else System.out.println(b);
		} else {
			if(b==0) System.out.println(a);
			else {
				System.out.println(Math.min(a, b));
			}
		}	
	}
}
