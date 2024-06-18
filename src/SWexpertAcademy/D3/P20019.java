package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P20019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // 전체
            String s = br.readLine();
            // 앞
            String first = s.substring(0,s.length()/2);
            // 뒤
            String last = s.substring(s.length()/2+1);

            int result = 0;
            result += isPalin(s);
            result += isPalin(first);
            result += isPalin(last);

            if (result == 3) {
                System.out.println("#"+(i+1)+" YES");
            } else {
                System.out.println("#"+(i+1)+" NO");
            }
        }
    }

    private static int isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }
}
