import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end;
    int value;

    public Node(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }
}
public class Main {
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end,cost));
            graph[end].add(new Node(start,cost));
        }

        System.out.println(prim(1,v));
    }

    private static int prim(int start, int n) {
        boolean[] visited = new boolean[n+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        int total_cost = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.end;
            int cost = node.value;

            if (visited[v]) continue;

            visited[v] = true;
            total_cost += cost;

            for (Node e : graph[v]) {
                if (!visited[e.end]) {
                    pq.add(e);
                }
            }
        }

        return total_cost;
    }
}
