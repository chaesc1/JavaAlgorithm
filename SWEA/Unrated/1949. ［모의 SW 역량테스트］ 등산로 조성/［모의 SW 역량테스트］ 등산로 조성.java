import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxHeight;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            maxHeight = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }

            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        // 가장 높은 곳에서 부터 탐색
                        visited[i][j] = true;
                        dfs(i, j, maxHeight, 1, 0);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    /**
     * (x, y)에서 시작하여 가능한 가장 긴 등산로를 찾기 위한 깊이 우선 탐색(DFS).
     *
     * @param x      현재 x 좌표
     * @param y      현재 y 좌표
     * @param height 현재 높이
     * @param length 현재 등산로 길이
     * @param count  지형을 깎은 횟수
     */
    private static void dfs(int x, int y, int height, int length, int count) {
        answer = Math.max(answer, length);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            // 다음 지점이 현재 지접 보다 낮은경우 dfs 깊이 우선 탐색 수행
            if (map[nx][ny] < height) {
                visited[nx][ny] = true;
                dfs(nx, ny, map[nx][ny], length + 1, count);
                visited[nx][ny] = false;
            } else {
                // 한번도 깎지 않았고 등산로를 만들 수 있는 경우
                if (count == 0) {
                    if (map[nx][ny] - K < height) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, height - 1, length + 1, count + 1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }

    }
}