package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

class SolutionP1844_BFS{
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int[][] visited;//방문한 곳 check
    public int solution(int[][] maps){
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];

        //0,0 부터 출발하고 n-1,m-1 이 되면 도착하는것
        bfs(maps,visited,n,m);

        answer = visited[n-1][m-1];
        if(answer == 0){
            return -1;
        }
        return answer;
    }

    public void bfs(int[][] maps, int[][] visited, int n, int m) {
        int x = 0,y = 0;
        visited[y][x] = 1;
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});

        while (!queue.isEmpty()){
            int [] now = queue.poll();
            int row = now[0];
            int col = now[1];

            for (int i = 0; i < 4; i++) {
                int curR = row + dx[i];
                int curC = col + dy[i];

                if(curR < 0 || curC < 0 || curR >= n || curC >= m){
                    continue;
                }
                if(visited[curR][curC] == 0 && maps[curR][curC] == 1){
                    queue.add(new int[]{curR,curC});
                    visited[curR][curC] = visited[row][col] + 1;
                }
            }
        }
    }
}
public class P1844_BFS {
    public static void main(String[] args) {
        SolutionP1844_BFS s = new SolutionP1844_BFS();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(s.solution(maps));
    }

}
