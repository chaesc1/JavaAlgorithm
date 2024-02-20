package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//N은 1보다 크거나 같고, 100보다 작거나 같은 자연수
// N = 99 -> 1100

public class P10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        //초기화
        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1L;
        }
    }
}
