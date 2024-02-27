package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            arr[i][0] = red;
            arr[i][1] = green;
            arr[i][2] = blue;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int result = Integer.MAX_VALUE;

            for (int j = 0; j < 3; j++) {
                if (i == j) { //마지막 집은 첫번째집과 같은색 일 수 없다.
                    dp[N - 1][j] = 100001;
                    continue;
                }
                dp[N - 1][j] = arr[N - 1][j];
            }
            //마지막부터 탐색시작 Top-down
            for (int j = N - 2; j > 0; j--) {
                dp[j][0] = Math.min(dp[j + 1][1], dp[j + 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j + 1][0], dp[j + 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j + 1][0], dp[j + 1][1]) + arr[j][2];
            }

            //첫번째 집기준 최솟값 탐색
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                result = Math.min(result, arr[0][i] + dp[1][j]);
                answer = Math.min(result,answer);
            }
        }

        System.out.println(answer);

    }
}
