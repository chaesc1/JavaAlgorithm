package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P1744 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        int minCnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] < 0) {
                minCnt++;
            }
        }

        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        int ans = 0;
        //음수 개수 minCnt
        for (int i = 1; i < minCnt; i+=2) {
            ans += (arr[i-1] + arr[i]);
        }

        if (minCnt % 2 == 1) {
            ans += arr[minCnt - 1];
        }

    }
}
