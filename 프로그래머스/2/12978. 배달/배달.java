import java.util.*;

class Solution {
    static class Node {
        int end;
        int cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();
        
        for (int[] edge : road) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            adjMap.putIfAbsent(u, new HashMap<>());
            adjMap.putIfAbsent(v, new HashMap<>());
            
            // 더 짧은 거리의 간선만 저장
            adjMap.get(u).put(v, Math.min(adjMap.get(u).getOrDefault(v, Integer.MAX_VALUE), cost));
            adjMap.get(v).put(u, Math.min(adjMap.get(v).getOrDefault(u, Integer.MAX_VALUE), cost));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0; // 시작점은 0으로 초기화
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.cost > dist[now.end]) continue;
            if (now.cost > K) continue; // 가지치기 조건
            
            Map<Integer, Integer> neighbors = adjMap.get(now.end);
            if (neighbors != null) {
                for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                    int nextEnd = entry.getKey();
                    int nextCost = entry.getValue();
                    
                    if (now.cost + nextCost < dist[nextEnd]) {
                        dist[nextEnd] = now.cost + nextCost;
                        pq.add(new Node(nextEnd, dist[nextEnd]));
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
}
