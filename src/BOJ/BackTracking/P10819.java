package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10819 {
    static int N;
    static int max_result = Integer.MIN_VALUE;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max_result);
    }

    private static void dfs(int count) {
        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(selected[i] - selected[i+1]);
            }
            max_result = Math.max(sum,max_result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                selected[count] = arr[i];
                visited[i] = true;
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
}
