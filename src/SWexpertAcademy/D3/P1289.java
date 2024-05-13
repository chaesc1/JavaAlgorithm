package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String memory;
        char before;
        int count;
        for (int i = 1; i <= T; i++) {
            memory = br.readLine();
            before = '0';
            count = 0;

            for (int j = 0; j < memory.length(); j++) {
                if (memory.charAt(j) != before) {
                    before = memory.charAt(j);
                    count++;
                }
            }
            System.out.printf("#%d %d\n", i, count);
        }
    }
}
