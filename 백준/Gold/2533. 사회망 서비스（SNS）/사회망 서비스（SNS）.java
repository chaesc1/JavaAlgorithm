import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int N;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        // 특정 노드들이 얼리어답터인지 아닌지에 따른 정답 도출
        // dp[num][0] -> 얼리어답터인 경우
        // dp[num][1] -> 얼리어답터가 아닌 경우
        solve(1);
        int answer = Math.min(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }

    private static void solve(int num) {
        visited[num] = true;
        dp[num][0] = 1;

        for (int next : graph[num]) {
            if (!visited[next]) {
                solve(next);
                dp[num][1] += dp[next][0];
                dp[num][0] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}