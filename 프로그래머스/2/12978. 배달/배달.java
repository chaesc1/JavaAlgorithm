import java.util.*;

class Solution {
    private static class Node {
        int dest, cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        // 인접 리스트 저장할 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        //road 정보를 인접리스트에 저장 - 무방향 그래프
        for(int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1],edge[2]));
            adjList[edge[1]].add(new Node(edge[0],edge[2]));
        }
        
        int[] dist = new int[N+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost , o2.cost));
        
        pq.add(new Node(1,0));
        dist[1] = 0; // 시작점은 dist = 0 으로
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(dist[now.dest] < now.cost) {
                continue;
            }
            
            for(Node next : adjList[now.dest]) {
                if(dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node (next.dest,dist[next.dest]));
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}