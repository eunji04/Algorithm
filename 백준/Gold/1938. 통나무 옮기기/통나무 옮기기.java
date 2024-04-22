import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static Character[][] arr;
	
	static int[][] visited1; // 가로로 되어 있을 때 방문 여부
	static int[][] visited2; // 세로로 되어 있을 때 방문 여부
	
	static int ans;

	static class Pair{
		int x1; int y1; int x2; int y2; int x3; int y3; int dir;
		public Pair(int x1, int x2, int x3, int y1, int y2, int y3, int dir) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.dir = dir;
		}
	}
	
	static int ex1, ex2, ex3, ey1, ey2, ey3;
	
	static Queue<Pair> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Character[N][N];
		
		int startX1 = -1; int startX2 = -1; int startX3 = -1;
		int startY1 = -1; int startY2 = -1; int startY3 = -1;
		ex1 = -1; ex2 = -1; ex3 = -1;
		ey1 = -1; ey2 = -1; ey3 = -1;
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				Character c = s.charAt(j);
				if(c == '1') arr[i][j] = '1'; 
				else {
					arr[i][j] = '0';
				}
				
				if(c == 'B') {
					if(startX1 != -1) {
						if(startX2 != -1) {
							startX3 = i; startY3 = j;
						} else {
							startX2 = i; startY2 = j;
						}
					} else {
						startX1 = i; startY1 = j;
					}
				} else if (c == 'E') {
					if(ex1 != -1) {
						if(ex2 != -1) {
							ex3 = i; ey3 = j;
						} else {
							ex2 = i; ey2 = j;
						}
					} else {
						ex1 = i; ey1 = j;
					}
				}
				
			}
		}
		
		que = new ArrayDeque<>();
		
		visited1 = new int[N][N];
		visited2 = new int[N][N];
		
		if(startX1 == startX2) {
			// 가로
			visited1[startX2][startY2] = 1;
			que.offer(new Pair(startX1, startX2, startX3, startY1, startY2, startY3, 1));
		} else if(startX1 != startX2) {
			// 세로
			visited2[startX2][startY2] = 1;
			que.offer(new Pair(startX1, startX2, startX3, startY1, startY2, startY3, -1));
		}
		
		bfs();
		if(ans != 0) System.out.println(ans-1);
		else System.out.println(ans);
		
	}
	
	static boolean inRange(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		else return true;
	}
	
	static boolean canGo(int x, int y) {
		if(!inRange(x,y)) return false;
		else if(arr[x][y] == '1') return false;
		else return true;
	}
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			Pair p = que.poll();
			
			int x1 = p.x1;
			int x2 = p.x2;
			int x3 = p.x3;
			int y1 = p.y1;
			int y2 = p.y2;
			int y3 = p.y3;
			int dir = p.dir;
			
			if(x1 == ex1 && y1 == ey1 && x2 == ex2 && y2 == ey2 && x3 == ex3 && y3 == ey3) {
				if(dir == 1) ans = visited1[x2][y2];
				else if(dir == -1) ans = visited2[x2][y2];
				return;
			}
			
			if(dir == 1) {
				
				
				// 위로
				if(canGo(x1-1, y1) && canGo(x2-1, y2) && canGo(x3-1, y3) && visited1[x2-1][y2]==0) {
					que.offer(new Pair(x1-1, x2-1, x3-1, y1, y2, y3, 1));
					visited1[x2-1][y2] = visited1[x2][y2]+1;
				}
				
				// 아래로
				if(canGo(x1+1, y1) && canGo(x2+1, y2) && canGo(x3+1, y3) && visited1[x2+1][y2]==0) {
					que.offer(new Pair(x1+1, x2+1, x3+1, y1, y2, y3, 1));
					visited1[x2+1][y2] = visited1[x2][y2]+1;
				}
				
				// 왼쪽으로
				if(canGo(x2, y1-1) && visited1[x2][y1-1] ==0) {
					que.offer(new Pair(x1, x2, x3, y1-1, y2-1, y3-1, 1));
					visited1[x2][y2-1] = visited1[x2][y2]+1;
				}
				
				// 오른쪽으로
				if(canGo(x2, y3+1) && visited1[x2][y2+1] ==0) {
					que.offer(new Pair(x1, x2, x3, y1+1, y2+1, y3+1, 1));
					visited1[x2][y2+1] = visited1[x2][y2]+1;
				}
				
				// 90도 회전
				if(canGo(x2-1, y1) && canGo(x2-1, y2) && canGo(x2-1, y3) && canGo(x2+1, y1) && canGo(x2+1, y2) && canGo(x2+1, y3) && visited2[x2][y2] == 0) {
					que.offer(new Pair(x2-1, x2, x2+1, y2, y2, y2, -1));
					visited2[x2][y2] = visited1[x2][y2]+1;
				}
				
			}
			
			else if(dir == -1) {
				
				
				// 왼쪽으로
				if(canGo(x1, y1-1) && canGo(x2, y2-1) && canGo(x3, y3-1) && visited2[x2][y2-1]==0) {
					que.offer(new Pair(x1, x2, x3, y1-1, y2-1, y3-1, -1));
					visited2[x2][y2-1] = visited2[x2][y2]+1;
				}
				
				// 오른쪽으로
				if(canGo(x1, y1+1) && canGo(x2, y2+1) && canGo(x3, y3+1) && visited2[x2][y2+1]==0) {
					que.offer(new Pair(x1, x2, x3, y1+1, y2+1, y3+1, -1));
					visited2[x2][y2+1] = visited2[x2][y2]+1;
				}
				
				// 위로
				if(canGo(x1-1, y1) && visited2[x2-1][y2] ==0) {
					que.offer(new Pair(x1-1, x2-1, x3-1, y1, y2, y3, -1));
					visited2[x2-1][y2] = visited2[x2][y2]+1;
				}
				
				// 아래로
				if(canGo(x3+1, y3) && visited2[x2+1][y1] ==0) {
					que.offer(new Pair(x1+1, x2+1, x3+1, y1, y2, y3, -1));
					visited2[x2+1][y2] = visited2[x2][y2]+1;
				}
				
				// 90도 회전
				if(canGo(x1, y1-1) && canGo(x2, y2-1) && canGo(x3, y3-1) && canGo(x1, y1+1) && canGo(x2, y2+1) && canGo(x3, y3+1) && visited1[x2][y2] == 0) {
					que.offer(new Pair(x2, x2, x2, y2-1, y2, y2+1, 1));
					visited1[x2][y2] = visited2[x2][y2]+1;
				}
				
			}
			
		}
		
	}
	
}
