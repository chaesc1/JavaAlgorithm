package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17642 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            long cnt = 0L;
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long num = b - a;
            if (num == 0) {
                cnt = 0;
            } else if (num < 2) {
                cnt = -1;
            } else if (num % 2 == 0) {
                cnt = num / 2;
            } else {
                cnt = (num - 3) / 2 + 1;
            }

            System.out.println("#" + (i + 1) + " " + cnt);
        }
    }
}
