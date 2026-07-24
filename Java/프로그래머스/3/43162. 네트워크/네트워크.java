import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                answer++;
                // 방문하지 않은 노드면 dfs
                dfs(i,visited,computers);
            }
        }
        return answer;
    }
    
    public static void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        for(int j=0; j<computers.length; j++){
            if(computers[i][j] == 1 && !visited[j]) {
                dfs(j, visited, computers);
            }
        }
    }
}