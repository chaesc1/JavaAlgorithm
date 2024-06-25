package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1486 {
    static int N, B, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            dfs(0, 0);
            System.out.println("#" + t + " " + (answer - B));
        }
    }

    private static void dfs(int start, int sum) {
        if (sum >= B) {
            answer = Math.min(answer, sum);
            return;
        }
        //base case
        if (start == N) {
            return;
        }

        for (int i = start; i < N; i++) {
            if(visited[i]) continue;  // 만약 이미 방문한 노드라면 스킵
            visited[i] = true;
            dfs(start + 1, sum + arr[i]);
            visited[i] = false;
        }
    }
}
