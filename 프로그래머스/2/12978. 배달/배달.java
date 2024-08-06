import java.util.*;

class Solution {
    static class Node {
        int end;
        int cost;
        
        public Node(int end,int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1],edge[2]));
            adjList[edge[1]].add(new Node(edge[0],edge[2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost ,o2.cost));
        pq.add(new Node(1,0));
        dist[1] = 0; // 시작점은 0으로 초기화
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.cost > dist[now.end]) continue;
            if (now.cost > K) continue; // 가지치기 조건 추가
            for(Node next : adjList[now.end]) {
                if(now.cost + next.cost < dist[next.end]) {
                    dist[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
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