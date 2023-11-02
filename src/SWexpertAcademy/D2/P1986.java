package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int sum = 0;
            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= num; i++) {
                if(i % 2 == 0) {
                    sum -= i;
                }else {
                    sum += i;
                }
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
