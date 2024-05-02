import java.util.*;

class Solution {
    private static class Node {
        int x;
        int y;
        int dir;
        int cost;
        
        public Node(int x,int y,int dir,int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private static boolean isValid(int x,int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    // private static int calculateCorner()
    private static int N;
    private static int[][][] visited;
    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {-1,0,1,0};
    
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];
            
        //BFS
        int answer = Integer.MAX_VALUE;     
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,-1,0)); //x,y,dir,cost
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                // 범위 밖 || 시작점이 차단 || 벽이면
                if(isBlocked(board, nx, ny)) continue;
                
                // 새로운 비용 계산
                int newCost = calculateCost(i,now.dir,now.cost);
                //
                if(nx == N-1 && ny == N-1) {
                    
                    answer = Math.min(answer, newCost);
                } else if(visited[nx][ny][i] == 0 || visited[nx][ny][i] > newCost) {
                    queue.add(new Node(nx,ny,i,newCost));
                    visited[nx][ny][i] = newCost;
                }
            }
        }
        return answer;
     }
    
    private static boolean isBlocked(int[][] board,int x, int y) {
        return (x == 0 && y == 0) || !isValid(x,y) || board[x][y] == 1;
    }
    
    private static int calculateCost(int direction, int prevDirection, int cost) {
        // 방향이 정해져 있지 않고 , 서로 반대방향 차이 = 2 반대 방향은 탐색할 필요도 없음 
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        } 
        return cost + 600;
    }
}