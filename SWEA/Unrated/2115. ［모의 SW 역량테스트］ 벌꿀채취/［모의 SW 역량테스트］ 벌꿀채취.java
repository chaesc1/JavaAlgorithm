import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리: 20,836 KB, 시간: 129 ms
 */
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

            // 주어진 벌꿀 정보 입력 받기
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

    // 두 일꾼이 선택할 수 있는 최대 수익 조합 찾기
    private static int getMaxTotalProfit() {
        int maxProfits = 0;

        // 두 일꾼의 벌통 조합 중 최대 수익을 찾음
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 <= N - M; j1++) {
                for (int i2 = i1; i2 < N; i2++) {
                    // 같은 행인 경우 겹치지 않도록 방문 가능한 열의 범위를 설정
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

    // 각 벌통 섹션의 최대 수익 미리 계산
    private static void preComputeMaxProfit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                maxProfit[i][j] = getMaxProfitForSection(i, j);
            }
        }
    }

    // 지정된 섹션에서 최대 수익 계산
    private static int getMaxProfitForSection(int row, int col) {
        int maxProfit = 0;

        // 부분 집합 생성 및 수익 계산
        for (int subset = 0; subset < (1 << M); subset++) {
            int sum = 0, profit = 0;
            for (int k = 0; k < M; k++) {
                if ((subset & (1 << k)) != 0) {
                    sum += map[row][col + k];
                    profit += map[row][col + k] * map[row][col + k];
                }
            }
            if (sum <= C) {
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}