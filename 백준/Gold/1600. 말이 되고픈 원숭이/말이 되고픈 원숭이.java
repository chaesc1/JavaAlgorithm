import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Point {
        int x, y, k, depth;

        Point(int x, int y, int k, int depth) {
            this.x = x;
            this.y = y;
            this.k = k; // 말의 움직임을 몇번 더 사용할 수 있는지 기록
            this.depth = depth; // 현재까지의 이동 횟수 기록
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1]; // 각 위치에서 사용 가능한 말의 움직임 횟수에 대해 방문 여부 체크

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, K, 0));
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 목적지에 도달한 경우
            if (p.x == H - 1 && p.y == W - 1) {
                return p.depth;
            }

            // 일반적인 네 방향 이동
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][p.k] && map[nx][ny] == 0) {
                    visited[nx][ny][p.k] = true;
                    queue.offer(new Point(nx, ny, p.k, p.depth + 1));
                }
            }

            // 말의 움직임 사용
            if (p.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = p.x + hx[i];
                    int ny = p.y + hy[i];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][p.k - 1] && map[nx][ny] == 0) {
                        visited[nx][ny][p.k - 1] = true;
                        queue.offer(new Point(nx, ny, p.k - 1, p.depth + 1));
                    }
                }
            }
        }

        // 목적지에 도달할 수 없는 경우
        return -1;
    }
}