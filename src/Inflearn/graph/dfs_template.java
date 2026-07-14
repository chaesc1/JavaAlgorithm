package Inflearn.graph;

import java.util.List;

public class dfs_template {
    void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        dfs(0, graph, visited);
    }

    private void dfs(int curr, List<List<Integer>> graph, boolean[] visited) {
        // 1. 방문
        visited[curr] = true;

        // 2. 방문 안한 다음 노드 찾기
        for(int next : graph.get(curr)) {
            if (!visited[next]) {
                // 3. 다음 노드 DFS 실행
                dfs(next, graph, visited);
            }
        }
    }
}
