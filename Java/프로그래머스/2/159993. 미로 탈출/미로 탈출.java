import java.util.*;

class Solution {
    private final static int[] dx = {-1,1,0,0};
    private final static int[] dy = {0,0,-1,1};
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        // 좌표 저장 배열
        int[] start = null;
        int[] lever = null;
        int[] end = null;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'S') start = new int[] {i,j};
                if(map[i][j] == 'L') lever = new int[] {i,j};
                if(map[i][j] == 'E') end = new int[] {i,j};
            }
        }
        
        int startToLever = bfs(map, start, lever, n, m);
        int leverToEnd = bfs(map, lever, end, n, m);
        
        if(startToLever == -1 || leverToEnd == -1) return -1;
        return startToLever + leverToEnd;
    }
    
    private int bfs(char[][] map, int[] from, int[] to, int n, int m)  {
        int[][] dist = new int[n][m];
        for(int[] row : dist) {
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> q = new ArrayDeque();
        q.offer(from);
        dist[from[0]][from[1]] = 0; // 첫 시작 0 으로 초기화, -1 이 아니면 방문표시 
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            if (curX == to[0] && curY == to[1]) return dist[curX][curY];
            
            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if(map[nx][ny] == 'X') continue;
                if(dist[nx][ny] != -1) continue; // 이미 방문한 곳이면 
                
                dist[nx][ny] = dist[curX][curY] + 1;
                q.offer(new int[] {nx,ny});
            }
        }
        
        return -1;
    }
}