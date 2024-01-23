import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int w;
    int cost;

    Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    //간선을 오름차순으로 정렬
    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}
public class PrimAlgo {

    //최소 신장 트리를 찾기 위한 그리디 패러다임 알고리즘

    //Step1 : 임의의 정점을 선택하여 비어있는 T에 포함 - T는 한 개인의 트리
    //Step2 : T 에 있는 노드와 T 에 없는 노드 사이의 간선 중 가중치가 최소인 간선을 찾는다
    //Step3 : 찾은 간선이 연결하는 두 노드 중, T 에 없던 노드를 T에 포함시킨다 (step 1에서 찾은 간선도 같이 T에 포함됩니다.)
    //Step4 : 모든 노드가 T에 포함될때 까지 2,3을 반복

    //간선 저장을 위한 클래스
    static List<Edge> [] graph;
    public static void prim(int start, int n) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if (visited[v]) continue; //방문표시된 노드면 뛰어넘고

            visited[v] = true;
            total += cost;

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //그래프 선언하고 간선 리스트로 표현
        graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Edge(w,cost));
            graph[w].add(new Edge(v,cost));
        }

        prim(1,n);
    }
}