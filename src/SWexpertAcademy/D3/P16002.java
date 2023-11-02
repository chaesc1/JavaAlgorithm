package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 1000000;
            while (true) {
                cnt--;
                if (!isPrime(cnt) && !isPrime(cnt + n)) {
                    System.out.printf("#%d %d %d\n", t, cnt + n, cnt);
                    break;
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
