package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2817_Re {
    static int N, K, count;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Tc = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= Tc; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            dfs(0, 0);
            System.out.println("#" + tc + " " + count);
        }

    }

    private static void dfs(int sum, int idx) {
        //base Case
        if (idx == N) {
            if (sum == K) {
                count++;
            }
            return;
        } else {
            dfs(sum, idx + 1);
            sum += arr[idx];
            dfs(sum, idx + 1);
        }
    }
}
