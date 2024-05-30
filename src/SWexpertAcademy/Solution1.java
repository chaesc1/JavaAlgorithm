package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {
    static int N, K, max;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= n; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            max = 0;

            for (int i = 0; i < N; i++) {
                max = Math.max(max, dfs(i));
            }

            System.out.println("#"+tc+" "+max);
        }
    }

    public static int dfs(int index) {
        int cnt = 1;

        for (int i = index + 1; i < N; i++) {
            if (arr[i] - arr[index] <= K) {
                cnt++;
            } else {
                break; // 이미 정렬된 배열이기 때문에 K 이상의 차이가 나면 뒤에 있는 수들은 더 큰 차이
            }
        }

        return cnt;
    }
}
