package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1389 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // V
        M = Integer.parseInt(st.nextToken()); // E

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.print(sb);
    }

    private static void bfs(int start) {
        int count = 0;
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, count}); // 시작정보 저장

        boolean[] visited = new boolean[N + 1]; // 방문 확인 배열
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int cur = info[0];
            int dist = info[1];
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    result += dist + 1;
                    visited[next] = true;
                    queue.add(new int[] {next,dist+1});
                }
            }
        }
        if (result < MIN) {
            MIN = result;
            answer = start;
        }
    }
}
