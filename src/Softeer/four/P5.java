package Softeer.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5 {

    static class Pos {
        public int x;
        public int y;
        public int moves;

        public Pos(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static boolean isValid(int x, int y, int h, int w) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    private static int bfs(int h, int w, boolean[][] visited) {
        visited[0][0] = true;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 0));
        int max_moves = 0;

        while (!queue.isEmpty()) {
            Pos curr = queue.poll();
            max_moves = Math.max(max_moves, curr.moves);

            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (isValid(nx, ny, h, w) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pos(nx, ny, curr.moves + 1));
                }
            }
        }

        return max_moves;
    }

    public static String knight_moves(int h, int w) {
        boolean[][] visited = new boolean[h][w];
        int max_moves = bfs(h, w, visited);

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (!visited[i][j]) {
                    return "F" + String.valueOf(max_moves);
                }
            }
        }

        return "T" + String.valueOf(max_moves);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(knight_moves(N,K));
    }
}