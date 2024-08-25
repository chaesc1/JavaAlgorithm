package SSAFY;

import java.util.Arrays;
import java.util.Scanner;

// 조합 : 서로 다른 n 개에서 순서를 고려하지 않고 r개를 모두 뽑는 경우의 수
public class Combination_final {
    static int N, R;
    static int[] numbers;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        combination(0, 0);
    }

    /**
     * @param cnt   조합의 수
     * @param start 시작위치
     */
    private static void combination(int cnt, int start) { // N개의 입력받은 수 중 R 개의 조합 찾기
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
