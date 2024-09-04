import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static int max;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;

            for (int k = 1; k <= N + 1; k++) {
                int operationCost = getOperation(k);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        solve(i, j, k, operationCost);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve(int x, int y, int k, int operationCost) {
        int houseCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(x - i) + Math.abs(y - j) < k && map[i][j] == 1) {
                    houseCount++;
                }
            }
        }

        int profit = (houseCount * M) - operationCost;
        if (profit >= 0) {
            max = Math.max(max, houseCount);
        }
    }

    private static int getOperation(int k) {
        return k * k + (k - 1) * (k - 1);
    }
}