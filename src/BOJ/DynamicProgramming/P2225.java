package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2225 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n + 1][k + 1];
        //0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수
        for (int i = 0; i <= n; i++) {
            cost[i][0] = 0;
            cost[i][1] = 1;
        }

        for (int i = 0; i <= k; i++) {
            cost[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                cost[i][j] = (cost[i - 1][j] + cost[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(cost[n][k]);
    }
}
