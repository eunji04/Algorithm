import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static Character[][] grid;
	static boolean[][] visited;
	
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	static boolean inRange(int x, int y) {
		if(x<0 || y<0 || x>=R || y>=C) return false;
		else return true;
	}
	
	static boolean canGo(int x, int y) { // 범위 벗어나거나 돌이면 못간다.
		if(!inRange(x,y)) return false;
		else {
			if(grid[x][y] == 'X') return false;
			else return true;
		}
	}
	
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Queue<Pair> water;
	static int time;
	
	static void bfsWater() {
		
		water = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(grid[i][j] == '*') {
					water.add(new Pair(i,j));
				}
			}
		}
		
		while(!water.isEmpty()) {
			
			Pair p = water.poll();
			int x = p.x; int y = p.y;
			
			for(int k=0; k<4; k++) {
				int newX = x+dx[k];
				int newY = y+dy[k];
				if(!canGo(newX,newY)) continue;
				
				if(grid[newX][newY] == '.') {
					grid[newX][newY] = '*';
				}
			}
			
		}
		
		time+=1;
		
		bfs();
		
	}
	
	
	
	static Queue<Pair> que;
	static int ans;
	
	static void bfs() {

		int size = que.size();
		if(size==0) return;
		
		for(int i=0; i<size; i++) {
			
			Pair p = que.poll();
			int x = p.x; int y = p.y;
			
			for(int k=0; k<4; k++) {
				int newX = x+dx[k];
				int newY = y+dy[k];
				
				if(!canGo(newX,newY) || visited[newX][newY]) continue;
				
				if(grid[newX][newY] == '*') continue;
				if(grid[newX][newY] == 'D') {
					ans+=1;
					return;
					// 정답
				}
				if(grid[newX][newY] == '.') {
					que.offer(new Pair(newX,newY));
					visited[newX][newY] = true;
				}
				
			}
			
		}
		
		bfsWater();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new Character[R][C];
		visited = new boolean[R][C];
		
		que = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				grid[i][j] = s.charAt(j);
				
				if(grid[i][j]=='S') {
					que.offer(new Pair(i,j));
					grid[i][j] = '.';
					visited[i][j] = true;
				}
				
			}
		}
		// grid 세팅 끝
		
		bfsWater();

		if(ans !=0) System.out.println(time);
		else System.out.println("KAKTUS");
		
	}

}
