package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9252 {
    static char[] inputA, inputB;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        inputA = br.readLine().toCharArray();
        inputB = br.readLine().toCharArray();

        int lenA = inputA.length;
        int lenB = inputB.length;

        dp = new int[lenA + 1][lenB + 1];

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (inputA[i] == inputB[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else  {
//                    dp[i+1][j+1] = Math.max(dp[i+1][j], )
                }
            }
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
