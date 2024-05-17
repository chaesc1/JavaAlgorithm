package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬끼리 최단거리를 구하는 문제
// bfs -> 최단거리를 보장해
// 섬인지 판단은?

public class P2146 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dist;
    private static int min = Integer.MAX_VALUE;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1을 기준을 탐색하면서 더이상 못가면 다른 숫자로 바꾼다.
        isIsland();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    visited = new boolean[N][N];
                    int result = bridge(i, j);

                    if (result == -1) {
                        continue;
                    }
                    if (min > result) {
                        min = result;
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static int bridge(int x, int y) {
        queue = new LinkedList<>();

        int num = map[x][y];
        visited[x][y] = true;
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int bridge = pos[2];

            if (map[curX][curY] != 0 || map[curX][curY] != num) {
                return bridge;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (!isValid(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == num || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, bridge + 1});
            }
        }
        return -1;
    }

    private static void isIsland() {
        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( !visited[i][j] && map[i][j] == 1)
                        visited[i][j] = true;
                queue.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    int nx = pos[0];
                    int ny = pos[1];

                    if (isValid(nx, ny)) {
                        continue;
                    }
                    if (visited[nx][ny]) {
                        continue;
                    }

                    if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = idx;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            idx++;
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 || x < N || y >= 0 || y < N;
    }
}
