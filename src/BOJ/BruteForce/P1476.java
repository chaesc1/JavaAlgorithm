package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1476 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M
        //(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 0;

        while (true) {
            year++;
            if ((E-year) % 15 == 0 && (S-year) % 28 == 0 && (M-year) % 19 == 0) {
                break;
            }
        }

        System.out.println(year);
    }
}
