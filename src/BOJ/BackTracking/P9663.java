package BOJ.BackTracking;

import java.util.Scanner;

public class P9663 {
    static int[] map;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N];
        backTracking(0);
        System.out.println(count);
    }

    public static void backTracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;
            if (isPossible(depth)) {
                backTracking(depth + 1);
            }
        }
    }

    public static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (map[col] == map[i]) {
                return false;
            }

            //대각선상 - 열 과 행의 차가 동일
            if (Math.abs(col - i) == Math.abs(map[i] - map[col])) {
                return false;
            }
        }

        return true;
    }
}
