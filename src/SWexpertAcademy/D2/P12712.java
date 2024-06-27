package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12712 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] dxX = {-1, -1, 1, 1};
    static int[] dyX = {-1, 1, -1, 1};

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 십자가
                    int sum1 = calc(dx, dy, i, j);
                    // 대각선
                    int sum2 = calc(dxX, dyX, i, j);
                    // 대각선 vs 십자가
                    int tmpMax = Math.max(sum1, sum2);

                    max = Math.max(max, tmpMax);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }

    private static int calc(int[] dx, int[] dy, int x, int y) {
        int tmp = arr[x][y];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;

                //valid
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    tmp += arr[nx][ny];
                }
            }
        }

        return tmp;
    }
}
