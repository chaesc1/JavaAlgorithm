import java.util.*;

public class Solution {

    private static int N, M, C;
    private static int[][] honey;
    private static int[][] maxHoneyProfit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            honey = new int[N][N];
            maxHoneyProfit = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    honey[i][j] = sc.nextInt();
                }
            }

            // 각 벌통 선택의 최대 수익을 미리 계산
            precomputeMaxProfit();
            int maxTotalProfit = getMaxTotalProfit();
            System.out.printf("#%d %d%n", t, maxTotalProfit);
        }
        sc.close();
    }

    private static void precomputeMaxProfit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                maxHoneyProfit[i][j] = getMaxProfitForSection(i, j);
            }
        }
    }

    private static int getMaxProfitForSection(int row, int col) {
        int maxProfit = 0;

        // 부분 집합 생성
        for (int subset = 0; subset < (1 << M); subset++) {
            int sum = 0, profit = 0;
            for (int k = 0; k < M; k++) {
                if ((subset & (1 << k)) != 0) {
                    sum += honey[row][col + k];
                    profit += honey[row][col + k] * honey[row][col + k];
                }
            }
            if (sum <= C) {
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    private static int getMaxTotalProfit() {
        int maxProfit = 0;

        // 두 일꾼의 벌통 조합 선택
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 <= N - M; j1++) {
                for (int i2 = i1; i2 < N; i2++) {
                    for (int j2 = (i1 == i2 ? j1 + M : 0); j2 <= N - M; j2++) {
                        int profit1 = maxHoneyProfit[i1][j1];
                        int profit2 = maxHoneyProfit[i2][j2];
                        maxProfit = Math.max(maxProfit, profit1 + profit2);
                    }
                }
            }
        }

        return maxProfit;
    }
}