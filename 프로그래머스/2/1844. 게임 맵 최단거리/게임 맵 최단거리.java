import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static class Node {
        int x;
        int y;
        
        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        int[][] dist = new int[N][M];
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        dist[0][0] = 1;
        
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (!isValid(nx,ny)) continue;
                
                if(maps[nx][ny] == 0) continue;
                
                // 처음 방문한 위치는 큐에 저장하고 거리 갱신
                if (dist[nx][ny] == 0) {
                    q.add(new Node(nx,ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }
        
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
    
    private static boolean isValid(int x,int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}