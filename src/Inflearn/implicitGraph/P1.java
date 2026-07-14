package Inflearn.implicitGraph;

import java.util.ArrayDeque;
import java.util.Queue;

// 구름의 개수1
public class P1 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;

    public int solution(int[][] sky) {
        n = sky.length;
        m = sky[0].length;
        boolean[][] visited = new boolean[n][m];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sky[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    //dfs(i,j,sky,visited);
                    bfs(i,j, sky, visited);
                }
            }
        }

        return answer;
    }

    private void bfs(int x, int y, int[][] sky, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx>=0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && sky[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

    }

    private void dfs(int x, int y, int[][] sky, boolean[][] visited) {
        visited[x][y] =true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= sky.length || ny < 0 || ny >= sky[0].length) continue;
            if (visited[nx][ny] || sky[nx][ny] == 0) continue;

            dfs(nx,ny, sky, visited);
        }
    }

    public static void main(String[] args) {
        P1 p1 = new P1();

        System.out.println(p1.solution(new int[][]{
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        })); // 3

        System.out.println(p1.solution(new int[][]{
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 1, 0}
        })); // 3

        System.out.println(p1.solution(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1}
        })); // 2
    }
}
