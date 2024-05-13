import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] graph;
    private static boolean[] visited;
    private static int N, M, V;
    private static int count; // Dfs 를 위한 count

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //노드의 수로 초기화하고
        graph = new int[N + 1][N + 1];
        //간선정보를 간선 수로 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = graph[end][start] = 1;// 연결됨을 1로 표현
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void BFS(int start) {
        // queue
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            start = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (graph[start][i] != 1) continue;

                queue.offer(i);
                visited[i] = true;
                System.out.print(i + " ");
            }
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        if (count == N) return;
        count++;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            if (graph[start][i] != 1) continue;

            DFS(i);
        }
    }
}
