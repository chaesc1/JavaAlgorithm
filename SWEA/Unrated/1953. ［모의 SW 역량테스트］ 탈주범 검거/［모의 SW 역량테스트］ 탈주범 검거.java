import java.util.*;

public class Solution {
    // 터널 타입에 따른 이동 가능 방향 설정
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

    private static boolean isConnected(int from, int to, int[] direction) {
        if (from == 0 || to == 0) {
            return false;
        }

        int fromY = direction[0], fromX = direction[1];
        int toY = -fromY, toX = -fromX;

        for (int[] toDirection : DIRECTION[to]) {
            if (toDirection[0] == toY && toDirection[1] == toX) {
                return true;
            }
        }
        return false;
    }

    private static int bfs(int N, int M, int R, int C, int L, int[][] tunnelMap) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{R, C});
        visited[R][C] = true;

        int count = 1;
        int time = 1;

        while (!queue.isEmpty() && time < L) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];
                for (int[] direction : DIRECTION[tunnelMap[y][x]]) {
                    int ny = y + direction[0];
                    int nx = x + direction[1];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && tunnelMap[ny][nx] != 0 && isConnected(tunnelMap[y][x], tunnelMap[ny][nx], direction)) {
                        queue.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
            time++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            int L = sc.nextInt();

            int[][] tunnelMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tunnelMap[i][j] = sc.nextInt();
                }
            }

            int result = bfs(N, M, R, C, L, tunnelMap);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}