package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            visited = new int[V + 1];

            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            if (isGroup()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean isGroup() {
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = 1; // 방문처리

                while (!queue.isEmpty()) {
                    int now = queue.poll();

                    for (int j = 0; j < graph[now].size(); j++) {
                        if (visited[graph[now].get(j)] == 0) { // 다음 노드가 방문하지 않았다면 큐에 삽입
                            queue.add(graph[now].get(j));

                            visited[graph[now].get(j)] = (visited[now] == 1) ? 2 : 1;
                        } else if (visited[graph[now].get(j)] == visited[now]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}