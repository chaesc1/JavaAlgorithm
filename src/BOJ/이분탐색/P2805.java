package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
    static long max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max;

        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int tree : arr) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }
            //원하는 길이보다 짧다면
            if (sum >= M){
                start = mid+1;
            } else {
                end = mid;
            }

        }
        System.out.println(end-1);
    }
}
