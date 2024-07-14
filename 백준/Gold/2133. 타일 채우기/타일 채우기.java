import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 0) { // N이 짝수인 경우에만 다음 코드를 실행합니다.
            int[] dp = new int[N + 1];
            dp[0] = 1;
            dp[2] = 3;
            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i - 2] * 3;
                for (int j = 4; j <= i; j += 2) {
                    dp[i] += dp[i - j] * 2;
                }
            }

            System.out.println(dp[N]);
        }
        else { // N이 홀수인 경우, 타일로 채울 수 없으므로 0 출력.
            System.out.println(0);
        }

    }
}
