package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());


            // init
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;

            //최종 정답 x.y 좌표
            int ansX = 0;
            int ansY = 0;

            int number = 1;

            for (int i = 1; i < 300; i++) {
                int j = i;
                int k = 1;
                for (int l = 0; l < i; l++) {
                    if (number == p) {
                        x1 = j;
                        y1 = k;
                    }

                    if (number == q) {
                        x2 = j;
                        y2 = k;
                    }

                    if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0) {
                        ansX = x1 + x2;
                        ansY = y1 + y2;
                    }

                    if (ansX == j && ansY == k) {
                        System.out.println("#"+t+" "+number);
                        break;
                    }
                    j--;
                    k++;
                    number++;
                }
            }
        }
    }
}
