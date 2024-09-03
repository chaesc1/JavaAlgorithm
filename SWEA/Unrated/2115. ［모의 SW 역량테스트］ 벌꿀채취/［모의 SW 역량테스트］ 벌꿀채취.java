import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int[][] maxProfit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxProfit = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 벌통 선택의 최대 수익 계산
            preComputeMaxProfit();
            int maxTotalProfit = getMaxTotalProfit();
            sb.append("#").append(tc).append(" ").append(maxTotalProfit).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int getMaxTotalProfit() {
        int maxProfits = 0;

        // 선택할 수 있는 두 벌통 조합 중 최대 수익을 찾음
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 <= N - M; j1++) {
                for (int i2 = i1; i2 < N; i2++) {
                    for (int j2 = (i1 == i2 ? j1 + M : 0); j2 <= N - M; j2++) {
                        int profit1 = maxProfit[i1][j1];
                        int profit2 = maxProfit[i2][j2];
                        maxProfits = Math.max(maxProfits, profit1 + profit2);
                    }
                }
            }
        }
        return maxProfits;
    }

    private static void preComputeMaxProfit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                maxProfit[i][j] = getMaxProfitForSection(i, j);
            }
        }
    }

    private static int getMaxProfitForSection(int row, int col) {
        ArrayList<Integer> profitList = new ArrayList<>();
        for (int subset = 0; subset < (1 << M); subset++) {
            int sum = 0;
            int profit = 0;
            for (int k = 0; k < M; k++) {
                if ((subset & (1 << k)) != 0) {
                    sum += map[row][col + k];
                    profit += map[row][col + k] * map[row][col + k];
                }
            }
            if (sum <= C) {
                profitList.add(profit);
            }
        }
        return Collections.max(profitList);
    }
}