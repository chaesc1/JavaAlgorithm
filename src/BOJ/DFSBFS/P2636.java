package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {
    static int N, M;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        boolean isClear = false; // 다 녹았는지 확인하는 플래그
        int time = 0;
        int cheezeCount = getCount();

        ArrayList<Integer> result = new ArrayList<>();
        while (!isClear) {
            time++;

            bfs(0, 0);

            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }

            int count = getCount();

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
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            // 치즈면?
                            map[nx][ny] = 2; // 녹아
                            visited[nx][ny] = true;
                        }
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        // map 이 2 면 모서리 라는 것이니까
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int getCount() {
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
