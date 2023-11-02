package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int hour1 = Integer.parseInt(st.nextToken());
            int min1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int min2 = Integer.parseInt(st.nextToken());

            int hour = 0;
            int min = 0;
            if (min1 + min2 > 60) {
                min = (min1 + min2) - 60;
                hour = hour1 + hour2 + 1;
                if(hour > 12) {
                    hour -= 12;
                }
                System.out.printf("#%d %d %d\n", t, hour, min);
            } else {
                min = (min1 + min2);
                hour = hour1 + hour2;
                if(hour > 12) {
                    hour -= 12;
                }
                System.out.printf("#%d %d %d\n", t, hour, min);
            }
        }
    }
}
