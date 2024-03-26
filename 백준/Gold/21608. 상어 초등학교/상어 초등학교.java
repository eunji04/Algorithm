import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, N;
	static int[][] seat;
	static int[][] student;
	static Queue<Integer> que;
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean inRange(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n) return false;
		else return true;
	}
	
	static class Pair{
		int x; int y; int cntNo; int cnt;
		public Pair(int x, int y, int cntNo, int cnt) {
			this.x = x;
			this.y = y;
			this.cntNo = cntNo;
			this.cnt = cnt;
		}
	}
	
	static Queue<Pair> check;
	public static void search() {
		
		while(!que.isEmpty()) {
			int a = que.poll();
			check = new ArrayDeque<>();
			
			int st1 = student[a][0];
			int st2 = student[a][1];
			int st3 = student[a][2];
			int st4 = student[a][3];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(seat[i][j]!=0) continue;
					
					int cntNo = 0;
					int cnt = 0;
					
					for(int k=0; k<4; k++) {
						int newX =i+dx[k];
						int newY =j+dy[k];
						if(!inRange(newX,newY)) continue;
						
						if(seat[newX][newY] ==0) cntNo+=1;
						else if(seat[newX][newY] ==st1) cnt+=1;
						else if(seat[newX][newY] ==st2) cnt+=1;
						else if(seat[newX][newY] ==st3) cnt+=1;
						else if(seat[newX][newY] ==st4) cnt+=1;
					}
					
					if(check.isEmpty()) check.offer(new Pair(i, j, cntNo, cnt));
					else {
						Pair p = check.peek();
						if(p.cnt == cnt) check.offer(new Pair(i, j, cntNo, cnt));
						else if(p.cnt < cnt) {
							check = new ArrayDeque<>();
							check.offer(new Pair(i, j, cntNo, cnt));
						}
					}
					
				}
			}
			
			if(check.size() ==1) {
				Pair p =check.poll();
				seat[p.x][p.y] = a;
				continue;
			}
			
			int x=0; int y=0; int cntNo=-1;
			while(!check.isEmpty()) {
				Pair p =check.poll();
				if(p.cntNo > cntNo) {
					cntNo =p.cntNo;
					x =p.x; y =p.y;
				}
			}
			seat[x][y] =a;
		}
		
	}
	
	public static int ans() {
		
		int result =0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				int st =seat[i][j];
				int st1 = student[st][0];
				int st2 = student[st][1];
				int st3 = student[st][2];
				int st4 = student[st][3];
				
				int cnt =0;
				for(int k=0; k<4; k++) {
					
					int newX =i+dx[k];
					int newY =j+dy[k];
					if(!inRange(newX,newY)) continue;
					
					if(seat[newX][newY] ==st1) cnt+=1;
					else if(seat[newX][newY] ==st2) cnt+=1;
					else if(seat[newX][newY] ==st3) cnt+=1;
					else if(seat[newX][newY] ==st4) cnt+=1;
					
				}
				
				if(cnt ==1) result+=1;
				else if(cnt ==2) result+=10;
				else if(cnt ==3) result+=100;
				else if(cnt ==4) result+=1000;
			}
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		
		N = n*n;
		seat = new int[n][n];
		student = new int[N+1][4];
		que = new ArrayDeque<>();
		
		StringTokenizer st = null;
		
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int index = Integer.parseInt(st.nextToken());
			 que.offer(index);
			 for(int j=0; j<4; j++) {
				 student[index][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		search();

		System.out.println(ans());
		
	}

}
