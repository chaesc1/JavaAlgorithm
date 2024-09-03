import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static final int[][][] DIRECTION = {
            {},
            {{-1, 0}, {1, 0}, {0, -1}, {0, 1}},   // 상, 하, 좌, 우
            {{-1, 0}, {1, 0}},                    // 상, 하
            {{0, -1}, {0, 1}},                    // 좌, 우
            {{-1, 0}, {0, 1}},                    // 상, 우
            {{1, 0}, {0, 1}},                     // 하, 우
            {{1, 0}, {0, -1}},                    // 하, 좌
            {{-1, 0}, {0, -1}}                    // 상, 좌
    };

    // 세로 크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L
    static int N, M, R, C, L;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = bfs(N, M, R, C, L, map);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());

    }

    // 연결되어있는지 체크
    private static boolean isConnected(int from, int to, int[] direction) {
        if (from == 0 || to == 0) return false;

        int fromX = direction[0];
        int fromY = direction[1];

        int toX = -fromX;
        int toY = -fromY;

        for (int[] toDirection : DIRECTION[to]) {
            if (toDirection[0] == toX && toDirection[1] == toY) return true;
        }
        return false;
    }

    private static int bfs(int n, int m, int r, int c, int l, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitied = new boolean[n][m];
        q.add(new int[]{r, c});
        visitied[r][c] = true;

        int count = 1;
        int time = 1;

        while (!q.isEmpty() && time < l) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int[] direction : DIRECTION[map[curX][curY]]) {
                    int nx = curX + direction[0];
                    int ny = curY + direction[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visitied[nx][ny]) continue;

                    if (isConnected(map[curX][curY], map[nx][ny], direction)) {
                        q.offer(new int[]{nx, ny});
                        visitied[nx][ny] = true;
                        count++;
                    }
                }
            }

            time++;
        }

        return count;
    }
}