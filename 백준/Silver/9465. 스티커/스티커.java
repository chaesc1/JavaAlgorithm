import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//TopDown
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    cost[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];
            for (int j = 2; j <= n; j++) {
                //점화식
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2]) + cost[0][j];
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2]) + cost[1][j];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }
}
