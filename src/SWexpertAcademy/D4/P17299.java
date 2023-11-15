package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17299 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            int len = s.length();

            if (len % 2 == 0) {
                System.out.println("#"+t+" "+(Integer.parseInt(s.substring(0,len/2)) + Integer.parseInt(s.substring(len/2))));
            } else {
                int sum1 = Integer.parseInt(s.substring(0,len/2)) + Integer.parseInt(s.substring(len/2));
                int sum2 = Integer.parseInt(s.substring(0,len/2+1)) + Integer.parseInt(s.substring(len/2+1));
                System.out.println("#"+t+" "+Math.min(sum1,sum2));
            }
        }
    }
}
