package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA10726 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int lastBit = (1 << N) - 1;
            int result = M & lastBit;
            if (lastBit == result) {
                System.out.println("#" + tc + " " + "ON");
            } else {
                System.out.println("#" + tc + " " + "OFF");
            }

        }

    }
}
