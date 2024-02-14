package BOJ.Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M,N)).append("\n");
        }

        System.out.println(sb);
    }

    private static int comb(int n,int m) {
        if (dp[n][m] > 0) return dp[n][m];

        if(n == m || m == 0) return dp[n][m] = 1;

        return dp[n][m] = comb(n-1,m-1) + comb(n-1,m);
    }
}
