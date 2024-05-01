import java.util.*;

class Solution {
    private final static int[] dx = {-1,1,0,0};
    private final static int[] dy = {0,0,-1,1};
    
    //위치 정보를 저장할 Point Class
    private static class Point {
        int nx,ny;
        
        public Point(int nx,int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }
    private static char[][] map;
    private static int n,m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        
        map = new char[n][m];
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        Point start = null, end = null, lever = null;
        
        //시작지점, 레버위치, 도착지점을 찾아
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'S') start = new Point(j,i);
                else if(map[i][j] == 'E') end = new Point(j,i);
                else if(map[i][j] == 'L') lever = new Point(j,i);
                
            }
        }
        
        //시작지점 -> 레버 까지의 최단거리
        //레버 -> 도착지점 까지의 최단거리
        int startToLever = bfs(start,lever);
        int leverToEnd = bfs(lever, end);
        
        if(startToLever == -1 || leverToEnd == -1) {
            return -1;
        } else {
            return startToLever + leverToEnd;
        }
    }
    
    private static int bfs(Point start, Point end) {
        int[][] dist = new int[n][m];
        ArrayDeque<Point> q = new ArrayDeque<>();
        
        dist[start.ny][start.nx] = 1;
        q.add(start);
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now.nx + dx[i];
                int ny = now.ny + dy[i];
                
                //범위 밖인 경우
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                //이미 방문한 지점인 경우
                if(dist[ny][nx] > 0) continue;
                
                //X 인 경우 
                if(map[ny][nx] == 'X') continue;
                
                dist[ny][nx] = dist[now.ny][now.nx] + 1;
                q.add(new Point(nx,ny));
                
                if(nx == end.nx && ny == end.ny) {
                    return dist[end.ny][end.nx] - 1;
                }
            }
        }
        //탐색을 못한 경우
        return -1;
    }
}