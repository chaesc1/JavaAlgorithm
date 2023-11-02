package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17319 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            String string = br.readLine();

            boolean isFlag = false;
            if (n % 2 == 0) {
                for (int i = 0; i < n / 2; i++) {
                    if (string.charAt(i) == string.charAt(n / 2 + i)) {
                        isFlag = true;
                    } else {
                        isFlag = false;
                        break;
                    }
                }
            } else {
                isFlag = false;
            }

            if (isFlag) {
                System.out.printf("#%d %s\n",t,"YES");
            } else {
                System.out.printf("#%d %s\n",t,"NO");
            }
        }
    }
}
