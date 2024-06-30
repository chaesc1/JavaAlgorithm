package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] money = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                money[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m + 1];
            dp[0] = 1;

            for (int coin : money) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}
