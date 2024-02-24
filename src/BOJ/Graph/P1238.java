package BOJ.Graph;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 문제
//N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
public class P1238 {
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end,int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N,M,X;
    static ArrayList<ArrayList<Node>> list; // 순방향으로 가는 리스트 생성
    static ArrayList<ArrayList<Node>> reverseList; // 되돌아가는 역방향 리스트 생성
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        //단방향 리스트 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end,cost));
            reverseList.get(end).add(new Node(start,cost));
        }
        
        int[] dist1 = dijkstra(list); // X 에서 모든 정점까지의 최단거리
        int[] dist2 = dijkstra(reverseList); // X 에서 모든 정점까지의 최단거리

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(dist1[i] + dist2[i] , answer);
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X,0)); // X 노드에서 시작 cost = 0;
        boolean[] visited = new boolean[N+1];
        //Return 할 dist 값
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[X] = 0; // 시작 정점 최단거리는 0 으로 초기화

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : list.get(cur)) {
                    if (!visited[next.end] && dist[next.end] > dist[cur] + next.cost) {
                        dist[next.end] = dist[cur] + next.cost;
                        pq.offer(new Node(next.end, dist[next.end]));
                    }
                }
            }
        }

        return dist;
    }
}
