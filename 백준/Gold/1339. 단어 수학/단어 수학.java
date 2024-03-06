import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] alpha = new int[26];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            int size = num.length();

            int exponent = (int) Math.pow(10, size - 1);

            for (int j = 0; j < size; j++) {
                alpha[num.charAt(j)-'A'] += exponent;
                exponent /= 10; // 1000 -> 100 -> 10 -> 1
            }
        }
        Arrays.sort(alpha);
//            for(int n : alpha) {
//                System.out.println(n);
//            }

        int ans = 0;
        for (int j = 25; j >= 17 ; j--) {
            ans += (alpha[j] * (j-16));
        }
        System.out.println(ans);
    }
}
