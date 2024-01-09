package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15657 {
    static int[] arr;
    static int[] printArr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        printArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.print(sb);
    }

    private static void dfs(int startIdx, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(printArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = startIdx; i < N; i++) {
            printArr[depth] = arr[i];
            dfs(i,depth+1);
        }
    }
}
