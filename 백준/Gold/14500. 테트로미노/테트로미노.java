import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // ㅏ ㅜ ㅓ ㅗ
    static int[][] wooX = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] wooY = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 맵 입력받고
            }
        }
        result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                // 방문 했던 점을 또 방문해야하기 때문
                dfs(i, j, map[i][j], 1);

                visited[i][j] = false;
                // ㅜ 모양 검색
                checkWoo(i, j);
            }
        }

        System.out.println(result);
    }
    private static void checkWoo(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean isOutOfRange = false;
            for (int j = 0; j < 4; j++) {
                int nx = x + wooX[i][j];
                int ny = y + wooY[i][j];

                if (!isValid(nx, ny)) {
                    isOutOfRange = true;
                    break;
                } else {
                    sum += map[nx][ny];
                }
            }
            if (!isOutOfRange) {
                result = Math.max(result, sum);
            }
        }
    }

    private static void dfs(int x, int y, int sum, int length) {
        if (length >= 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isValid(nx, ny)) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], length + 1);
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
