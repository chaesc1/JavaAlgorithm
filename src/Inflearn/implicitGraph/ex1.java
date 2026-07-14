package Inflearn.implicitGraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ex1 {
    void solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        bfs(0, 0, grid, visited);
    }

    private void bfs(int curX, int curY, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {0,1,1,1,0,-1,-1,-1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (grid[nx][ny] == 1) {
                        if (!visited[nx][ny]) {
                            q.offer(new int[]{nx,ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}
