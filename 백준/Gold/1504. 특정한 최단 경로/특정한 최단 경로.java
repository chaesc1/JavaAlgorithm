import com.sun.source.tree.BreakTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int cost;

    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class Main {
    static int N, E, answer;
    static boolean[] visited;
    static int[] dist;
    static int INF = 200000 * 1000;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //정점개수
        N = Integer.parseInt(st.nextToken());
        //간선개수
        E = Integer.parseInt(st.nextToken());

        //시작 정점 , 종료 정점 , 가중치
        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //인접리스트 구현
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        //반드시 거쳐야하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF) {
            answer = -1;
        } else {
            answer = Math.min(result1, result2);
        }

        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node next : graph.get(now.end)) {
                if (dist[next.end] > next.cost + now.cost) {
                    dist[next.end] = next.cost + now.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[end];
    }
}
