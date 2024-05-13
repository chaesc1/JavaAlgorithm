package BOJ.twoPointer;

// 두 용액

// 투포인터 문제


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;

        int[] result = new int[2];

        // 배열 정렬
        Arrays.sort(arr);

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                result[0] = arr[start];
                result[1] = arr[end];

                if (sum == 0) break;
            }

            if(sum < 0) start++;
            else end--;

        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
