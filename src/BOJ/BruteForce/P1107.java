package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1107 {
    static boolean[] isPossible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이동하려는 채널
        int M = Integer.parseInt(br.readLine()); //고장난 버튼 개수

        isPossible = new boolean[10];
        if ( M > 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                isPossible[num] = true; // 못누르게 체크표시.
            }
        }

        int remain = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String input = String.valueOf(i);
            int len = input.length(); //99 라면 2번 누른거

            boolean isBroken = false;//고장났는지 판별
            for (int j = 0; j < len; j++) {
                if (isPossible[Integer.parseInt(String.valueOf(input.charAt(j)))]) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int min = Math.abs(N - i) + len;
                remain = Math.min(remain,min);
            }
        }

        System.out.println(remain);
    }
}
