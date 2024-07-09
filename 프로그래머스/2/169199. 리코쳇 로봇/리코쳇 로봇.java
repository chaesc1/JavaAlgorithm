import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int startX,startY,endX,endY;
    static int row,col;
    
    public int solution(String[] board) {
        int answer = 0;
        row = board.length;
        col = board[0].length();
        map = new int[row][col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                char point = board[i].charAt(j);
                
                if(point == 'R') {
                    startX = i;
                    startY = j;
                }
                
                if(point == 'G') {
                    endX = i;
                    endY = j;
                }
                if(point == 'D') {
                    // 장애물이면 -1 처리
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
         // 최단거리 - > bfs
        bfs();
        if(map[endX][endY] == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = map[endX][endY];
        }
        return answer;
    }
    
    private static void bfs() {
        map[startX][startY] = 0;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {startX,startY});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                // 끝까지 가야해 - 장애물이나 벽까지 미끄러져 이동
                while(isValid(nx,ny) && map[nx][ny] != -1) {
                    nx += dx[i];
                    ny += dy[i];
                }
                // While 빠져나오면 이미 벽밖 or 장애물 좌표
                nx -= dx[i];
                ny -= dy[i];
                // 끝까지 갔는데 만약 시작지점이거나, 최단거리가 아니면 
                if(nx == cur[0] && ny == cur[1]) continue;
                if(map[nx][ny] <= map[cur[0]][cur[1]] + 1) continue;
                
                map[nx][ny] = map[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx,ny});
            }
        }
    }
    
    private static boolean isValid(int x,int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}