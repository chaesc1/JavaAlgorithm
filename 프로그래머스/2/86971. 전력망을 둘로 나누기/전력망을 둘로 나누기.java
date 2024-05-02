import java.util.*;

class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int N,answer;
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1; // 최대는 자기 자신노드와 나머지를 분리하는 경우 -> n-1
        
        adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : wires) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        visited = new boolean[n+1];
        dfs(1);
        
        return answer;
    }
    
    private static int dfs(int now) {
        visited[now] = true;
        
        int sum = 0;
        for(int next : adjList[now]) {
            if(!visited[next]) {
                // (전체노드 - 자식노드) - 자식노드 의 절댓값
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs((N-cnt)-cnt));
                sum += cnt;
            }
        }
        return sum + 1;
    }
}