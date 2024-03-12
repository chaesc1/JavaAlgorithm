import java.util.*;

/*
그래프 양방향 연결
다익스트라
*/
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;
    static int MAX = 10000000;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        } 
        
            
        for(int[] road : roads) {
            int start = road[0];
            int end = road[1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        dist = new int[n+1];
        Arrays.fill(dist,MAX);

        //다익스트라 
        dijkstra(destination);
        
        answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(dist[sources[i]] < MAX) answer[i] = dist[sources[i]];
            else answer[i] = -1;
        }
        return answer;
    }
    
    private static void dijkstra(int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.add(dest);
        
        dist[dest] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i=0; i<graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if(dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}