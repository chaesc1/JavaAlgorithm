package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6798 {
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        System.out.println(knightMove(startX - 1, startY - 1, endX - 1, endY - 1));
    }

    private static int knightMove(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return 0;
        }

        boolean[][] visited = new boolean[8][8];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int moves = now[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == endX && ny == endY) {
                    return moves + 1;
                }

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, moves + 1});
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
