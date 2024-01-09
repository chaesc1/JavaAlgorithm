package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15663 {
    static int[] arr;
    static int[] printArr;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        printArr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(printArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int back = -1;//이전 숫자

        for (int i = 0; i < N; i++) {
            int now = arr[i];
            if (now != back && !visited[i]) {
                back = now;
                visited[i] = true;
                printArr[depth] = now;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
