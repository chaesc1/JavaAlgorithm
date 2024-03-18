package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //최초의 시간
        int year = 0;
        while (true) {
            int answer = countIceBerg(); //DFS

            if (answer >= 2) {
                break;
            } else if (answer == 0) {
                year = 0;
                break;
            }

            //BFS
            bfs();
            year++;
        }

        System.out.println(year);
    }

    private static int countIceBerg() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    //dfs 재귀 탐색
                    dfs(i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!visited[nx][ny] && board[nx][ny] > 0) {
                dfs(nx,ny,visited);
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited  = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int cutY = now[1];

            int count = 0; //주변 바다 count
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = cutY + dy[i];

                //valid
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && board[nx][ny] == 0) {
                        count++; //주변의 0 만큼 감소를 시켜야함.
                    }
                }
            }
            if (board[curX][cutY] - count < 0) { // 0보다 작으면 0으로 초기화
                board[curX][cutY] = 0;
            } else {
                board[curX][cutY] -= count; //주변 바다의 영역만큼 감소를 진행해야함r
            }
        }
    }
}
