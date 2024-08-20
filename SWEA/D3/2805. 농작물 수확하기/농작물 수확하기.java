import java.io.BufferedReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            // 3일경우를 생각해보면
            // 맨 윗줄 부터 중앙갑  i = 0 : X = N / 2  Y = N/2
            // 다음줄 시작은 중앙값 (i / 2) 에서 한칸뒤 X = N/2 - 1 ~ Y = N / 2 + 1
            // 마지막줄은 다시 중앙 수확인다.
            // 즉 중앙이 되기 전까지는 범위가 늘어나고
            // 중앙 이후에는 범위가 다시 줄어든다.
            int sum = 0;
            int start = N / 2;
            int end = N / 2;

            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    sum += map[i][j];
                }
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