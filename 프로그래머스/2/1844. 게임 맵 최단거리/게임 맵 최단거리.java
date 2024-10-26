import java.util.*;

class Solution {
    
    public class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(0,0));
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!que.isEmpty()) {
            Pair p = que.poll();
            int x = p.x;
            int y = p.y;
            
            for (int i=0; i<4; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (0<=newX && 0<= newY && newX<n && newY<m){
                    if (!visited[newX][newY] && maps[newX][newY]!=0){
                        visited[newX][newY] = true;
                        maps[newX][newY] = maps[x][y]+1;
                        que.offer(new Pair(newX, newY));
                    }
                }
            }
        }
        
        if (maps[n-1][m-1]!=1) return maps[n-1][m-1];
        else return -1;
    }
}