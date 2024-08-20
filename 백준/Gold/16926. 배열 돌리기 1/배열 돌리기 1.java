import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리    시간
 * 39344	1180
 */
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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void rotate() {
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int firstRow = layer;
            int firstCol = layer;
            int lastRow = N - 1 - layer;
            int lastCol = M - 1 - layer;

            int topLeft = map[firstRow][firstCol];

            for (int i = firstCol; i < lastCol; i++) {
                map[firstRow][i] = map[firstRow][i + 1];
            }

            for (int i = firstRow; i < lastRow; i++) {
                map[i][lastCol] = map[i + 1][lastCol];
            }

            for (int i = lastCol; i > firstCol; i--) {
                map[lastRow][i] = map[lastRow][i - 1];
            }

            for (int i = lastRow; i > firstRow; i--) {
                map[i][firstCol] = map[i - 1][firstCol];
            }

            map[firstRow + 1][firstCol] = topLeft;
        }
    }
}