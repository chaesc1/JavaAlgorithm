import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate() {
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int firstRow = layer;
            int firstCol = layer;
            int lastRow = N - 1 - layer;
            int lastCol = M - 1 - layer;

            // Save the top-left element of the current layer
            int topLeft = map[firstRow][firstCol];

            // Move elements from top row (left to right) to the left
            for (int i = firstCol; i < lastCol; i++) {
                map[firstRow][i] = map[firstRow][i + 1];
            }

            // Move elements from right column (top to bottom) to the top
            for (int i = firstRow; i < lastRow; i++) {
                map[i][lastCol] = map[i + 1][lastCol];
            }

            // Move elements from bottom row (right to left) to the right
            for (int i = lastCol; i > firstCol; i--) {
                map[lastRow][i] = map[lastRow][i - 1];
            }

            // Move elements from left column (bottom to top) to the bottom
            for (int i = lastRow; i > firstRow; i--) {
                map[i][firstCol] = map[i - 1][firstCol];
            }

            // Place the saved top-left element to its new position
            map[firstRow + 1][firstCol] = topLeft;
        }
    }
}