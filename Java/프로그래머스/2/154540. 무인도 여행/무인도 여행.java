import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        System.out.println(map[0]);
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    // i,j 좌표에서 상하좌우로 bfs 돌려서 연결된 숫자 합
                    // -> list 에 add
                    list.add(bfs(i,j));
                }
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        if (list.size() == 0) {
            return new int[] {-1};
        }
        return answer;
    }
    
    public int bfs(int x, int y) {
        int sum = 0;
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            sum += Integer.parseInt(String.valueOf(map[curX][curY]));
            
            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny});
                }
            }
        }
        return sum;
    }
}