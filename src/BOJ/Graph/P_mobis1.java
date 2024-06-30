package BOJ.Graph;


import java.util.ArrayList;
import java.util.List;

public class P_mobis1 {
    static int[] visited;
    static List<List<Integer>> graph;
    public int solution(int n, int[][] edges) {
        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        visited = new int[n + 1]; // 방문 여부 및 폭죽 개수를 저장할 배열

        int minBombs = Integer.MAX_VALUE;

        // 모든 노드에 대해 DFS 수행
        for (int player = 1; player <= n; player++) {
            if (visited[player] == 0) { // 방문하지 않은 노드인 경우
                int totalBombs = dfs(player, -1); // -1로 부모를 표시하여 시작
                minBombs = Math.min(minBombs, totalBombs);
            }
        }

        // 모든 플레이어에게 폭죽을 주었을 때 2개 이상의 폭죽을 가진 플레이어가 있는지 확인
        for (int player = 1; player <= n; player++) {
            if (visited[player] >= 2) {
                return minBombs; // 승리 가능한 최소 폭죽 개수 반환
            }
        }

        return 1; // 모든 플레이어에게 폭죽을 주어도 조건을 만족하지 못할 경우
    }
    // DFS 함수 정의
    // node: 현재 탐색하는 노드 번호
    // parent: 이 노드의 부모 노드 번호
    // Returns: 현재 노드에 필요한 최소 폭죽 개수
    //         (현재 노드에 폭죽을 주지 않는 경우를 포함)
    private static int dfs(int node, int parent) {
        visited[node] = 1; // 현재 노드에 폭죽을 주는 경우

        int totalBombs = 1; // 최소한 한 개의 폭죽을 주어야 함

        // 자식 노드들을 탐색하면서 폭죽을 줄지 말지 결정
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue; // 부모 노드는 건너뜁니다
            if (visited[neighbor] == 0) { // 방문하지 않은 경우
                totalBombs += dfs(neighbor, node); // 자식의 폭죽 개수를 더함
            }
        }

        return visited[node] = totalBombs; // 현재 노드의 폭죽 개수 업데이트 및 반환
    }
    public static void main(String[] args) {
        P_mobis1 sol = new P_mobis1();

        int[][] edges1 = {{1, 3}, {2, 5}};
        int[][] edges2 = {{1, 3}, {1, 4}, {3, 4}};
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};

        System.out.println(sol.solution(5, edges1)); // Output: 4
        System.out.println(sol.solution(4, edges2)); // Output: 2
        System.out.println(sol.solution(4, edges3)); // Output: 1
    }
}