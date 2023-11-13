package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            //농장에 값 넣기
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }
            //규칙대로 더하기
            int sum = 0;
            int start = N / 2;
            int end = N / 2;
            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    sum += map[i][j];
                }
                //중간 전
                if (i < N / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }

            System.out.println("#"+tc+" "+sum);
        }
    }
}
