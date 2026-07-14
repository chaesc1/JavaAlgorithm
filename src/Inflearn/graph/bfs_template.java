package Inflearn.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class bfs_template {
    void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        bfs(0,graph, visited);
    }

    private void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 시작점  예약
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 방문
            int curr = queue.poll();

            // 다음 노드 예약
            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
