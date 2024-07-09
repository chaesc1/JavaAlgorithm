package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            int result = 0;
            if (s.charAt(0) == 'o') {
                result = 0;
            } else if (s.charAt(1) == 'o') {
                result = 1;
            } else {
                result = 2;
            }

            while (k > 0) {
                switch (result) {
                    case 0:
                        result = 1;
                        break;
                    case 1:
                        result = 0;
                        break;
                    case 2:
                        result = 1;
                        break;
                }
                k--;
            }
            System.out.println("#" + t + " " + result);
        }


    }
}
