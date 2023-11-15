package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2817 {
    static int[] arr;
    static int N,K,count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //원소 개수
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            dfs(0,0);
            System.out.println("#"+tc+" "+count);
        }
    }

    private static void dfs (int sum, int idx) {
        if (idx == N) { //전부 체크했을때
            if (sum == K) count++;
            return;
        } else {
            dfs(sum,idx+1);
            sum += arr[idx];
            dfs(sum,idx+1);
        }
    }
}
