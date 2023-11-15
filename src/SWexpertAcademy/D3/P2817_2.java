package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2817_2 {
    static int[] arr;
    static boolean[] isVisted;
    static int N,K,count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //원소 개수
            K = Integer.parseInt(st.nextToken());

            isVisted = new boolean[N];
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    isVisted[j] = false;
                }
                dfs(i,0);
            }
            System.out.println("#"+tc+" "+count);
        }
    }

    private static void dfs (int sum, int idx) {
        isVisted[idx] = true;
        sum += arr[idx];
        if (sum == K) {
            count++;
        }
        for (int i = idx; i < N; i++) {
            if (!isVisted[i]) {
                dfs(sum,i);
                isVisted[i] = false;
            }
        }
    }
}
