package Inflearn.implicitGraph;

public class dfs_template {
    int n;
    int m;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    void solution(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        dfs(0, 0, grid, visited);
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        visited[x][y] = true;
        // 방문 안한 다음 노드 찾기
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (grid[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        dfs(nx,ny,grid,visited);
                    }
                }
            }
        }
    }
}
