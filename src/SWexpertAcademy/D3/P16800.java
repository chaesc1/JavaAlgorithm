package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            long path = N-1;

            for (long i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    path = Math.min(path,(N/i) + i - 2);
                }
            }
            System.out.println("#"+tc+" "+path);
        }
    }
}
