import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//가중치 그래프
//다익스트라 문제 인거 같은데
class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];// 노드 방분 처리 배열
        int[] dist = new int[V + 1];
        List<Node>[] list = new List[V + 1]; //연결 정보 저장
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //시작 , 도착 , 가중치 저장
            list[u].add(new Node(v, w));
        }

        //다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        dist[K] = 0;
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.end]) {
                visited[now.end] = true; //방문처리
            }

            for (int i = 0; i < list[now.end].size(); i++) {
                //이어지는 다음 정점
                Node next = list[now.end].get(i);
                //다음 정점이 방문 하지 않고? ->
                //현재 가중치 + 다음 노드 가중치 값 < 해당 경로로의 최단경로값
                if (!visited[next.end] && now.weight + next.weight < dist[next.end]) {
                    dist[next.end] = now.weight + next.weight;
                    //다음 방문할 노드의 경로를 우선순위 큐에 삽입
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
