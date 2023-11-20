package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2814 {
    static int N, M;
    static int answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            answer = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new int[N + 1][N + 1];
            //정점 간선 연결

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = graph[to][from] = 1;
            }

            //최장 경로 찾기
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                visited[j] = true;
                dfs(j, 1);
                visited[j] = false;
            }

            System.out.println("#"+i+" "+answer);
        }
    }

    private static void dfs(int start, int cnt) {
        for (int i = 1; i <= N; i++) {
            if (i == start) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            if (graph[start][i] != 1) {
                continue;
            }

            visited[i] = true;
            dfs(i,cnt+1);
            visited[i] = false;
        }
        answer = Math.max(cnt,answer);
    }
}
