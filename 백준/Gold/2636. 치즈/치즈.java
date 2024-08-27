import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 치즈가 다 녹았는지 체크
        boolean isClear = false;
        int time = 0;
        int cheezeCount = getCheezeCount();
        ArrayList<Integer> result = new ArrayList<>();

        while (!isClear) {
            time++;
            bfs(0, 0);

            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }
            int count = getCheezeCount();
            if (count == 0) {
                isClear = true;
            } else {
                result.add(count);
            }
        }

        System.out.println(time);
        if (!result.isEmpty()) {
            System.out.println(result.get(result.size() - 1));
        } else {
            System.out.println(cheezeCount);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 2; // 녹음 표시
                    visited[nx][ny] = true;
                }
                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int getCheezeCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}