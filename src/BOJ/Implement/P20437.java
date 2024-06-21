package BOJ.Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            // 주어진 문자열에서 알파벳 갯수를 카운트해본다
            int[] alpha = new int[26];
            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            // 해당 문자열을 처음 부터 탐색을 시작한다.
            for (int i = 0; i < w.length(); i++) {
                if (alpha[w.charAt(i) - 'a'] < k) {
                    continue;
                }

                int count = 1;
                for (int j = i + 1; j < w.length(); j++) {
                    if (w.charAt(i) == w.charAt(j)) {
                        count++;
                    }

                    if (count == k) {
                        min = Math.min(min, (j - i) + 1);
                        max = Math.max(max, (j - i) + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }

    }
}
