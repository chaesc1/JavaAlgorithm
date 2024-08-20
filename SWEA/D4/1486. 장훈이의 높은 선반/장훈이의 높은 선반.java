import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, B;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+tc+" "+(result-B));
        }
    }

    private static void dfs(int idx, int sum) {
        if (sum >= B) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (arr[i] + sum < result) {
                dfs(i+1, arr[i] + sum);
            }
        }
    }
}