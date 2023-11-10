package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1217 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int pow_num = Integer.parseInt(st.nextToken());

            int ans = pow(num,pow_num);

            System.out.println("#"+i+" "+ans);
        }
    }
    public static int pow(int num, int pow_num) {
        if(pow_num == 0) {
            return 1;
        }
        return num * pow(num,pow_num-1);
    }
}
