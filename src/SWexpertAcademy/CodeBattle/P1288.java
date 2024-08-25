package SWexpertAcademy.CodeBattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1288 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int num = Integer.parseInt(br.readLine());
            int count = 1; // 곱할 수

            boolean[] cap = new boolean[10];
            int capCount = 0;

            while (capCount < 10) {
                int multi = num * count;
                String str = String.valueOf(multi);

                for (int i = 0; i < str.length(); i++) {
                    int digit = Character.digit(str.charAt(i), 10);

                    if (!cap[digit]) {
                        cap[digit] = true;
                        capCount++;
                    }
                }
                count++;
            }
            System.out.println("#" + tc + " " + num * (count - 1));
        }
    }
}
