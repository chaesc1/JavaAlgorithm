import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[1001];

        System.out.println(dp(n));

    }

    private static int dp(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (d[n] != 0) {
            return d[n];
        }
        d[n] = (dp(n - 1) + 2 * dp(n - 2)) % 10007;

        return d[n];
    }
}
