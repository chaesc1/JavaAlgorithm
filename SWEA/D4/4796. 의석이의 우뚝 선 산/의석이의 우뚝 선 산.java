import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            int upCount = 0;
            int downCount = 0;
            boolean ascending = true;

            for (int i = 1; i < N; i++) {
                if (arr[i] > arr[i - 1]) {
                    if (ascending) {
                        upCount++;
                    } else {
                        // 내리막 도중 또 오르막을 만나면 리셋
                        sum += upCount * downCount; // 이전까지의 오르막과 내리막 구간의 산들을 더해줌
                        upCount = 1; // 다시 새로운 오르막
                        downCount = 0;
                        ascending = true;
                    }
                } else if (arr[i] < arr[i - 1]) {
                    if (ascending && upCount > 0) {
                        ascending = false;
                        downCount = 1;
                    } else if (!ascending) {
                        downCount++;
                    }
                } else {
                    // 같은 높이의 반복이 나오면 리셋
                    sum += upCount * downCount;
                    upCount = 0;
                    downCount = 0;
                    ascending = true;
                }
            }

            // 마지막으로 쌓인 오르막 내리막 처리
            if (!ascending) {
                sum += upCount * downCount;
            }

            System.out.println("#" + tc + " " + sum);
        }

        scanner.close();
    }
}