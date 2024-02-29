import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            int start = e[0];
            int end = e[1];
            
            //양방향 그래프 연결
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        //방문표시
        boolean[] visited = new boolean[n+1];
        
        answer = bfs(graph,n,visited);
        
        return answer;
    }
    
    private static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        
        visited[1] = true; //1번 노드 방문처리
        q.add(new int[] {1,0});  //노드, depth 저장 
        
        int answer = 0;
        int maxDepth = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int v = now[0];
            int depth = now[1];
            
            if(depth == maxDepth) answer++;
            if(depth > maxDepth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for(int i=0; i<graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);
                if(!visited[next]) {
                    q.add(new int[] {next, depth+1});
                    visited[next] = true;
                }
            }
        }
        return answer;
    }
}