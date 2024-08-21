import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * - 2 이상의 어떤 정수 N이 있다.
 * - N을 N+1로 바꿀 수 있다.
 *
 * - 이 정수일 때, N을 제곱근으로 바꿀 수 있다.
 *
 * 게임의 목표는 N을 2로 만드는 것이다.
 * N을 2로 만들기 위해 조작해야 하는 횟수의 최솟값을 구하는 프로그램을 작성하라.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            long N = Long.parseLong(br.readLine());
            long cnt = 0;

            while (N > 2) {
                long sqrt = (long) Math.sqrt(N);

                if (sqrt * sqrt == N) {
                    N = sqrt;
                    cnt++;
                } else {
                    // 제곱근을 가질 수 있는 최소값구해서 N 과 빼면 -> 증가시켜야할 카운트 수
                    cnt += (sqrt + 1) * (sqrt + 1) - N;
                    N = (sqrt + 1) * (sqrt + 1);
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}