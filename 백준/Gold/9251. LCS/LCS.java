import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int length1 = str1.length();
        int length2 = str2.length();

        char[] toCharStr1 = new char[length1 + 1];
        char[] toCharStr2 = new char[length2 + 1];

        for (int i = 1; i <= length1; i++) {
            toCharStr1[i] = str1.charAt(i - 1);
        }

        for (int i = 1; i <= length2; i++) {
            toCharStr2[i] = str2.charAt(i - 1);
        }

        int[][] dp = new int[length2+1][length1+1];

        for (int i = 1; i <= length2; i++) {
            for (int j = 1; j <= length1; j++) {
                //두 문자가 같으면?
                if (toCharStr1[j] == toCharStr2[i]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //다를경우 대각선위, 바로 전 값중 큰 값을 넣어
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[length2][length1]);
    }
}
