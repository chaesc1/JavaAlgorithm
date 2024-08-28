import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//19,136 kb
//111 ms
public class Solution {
    static int[][] matrix;
    static boolean[] visited;
    static int maxNode;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            // 임시 저장소를 생성하여, 최대 노드 번호를 찾기 위해 필요한 데이터 (간선의 수의 2배)
            int[] edgeData = new int[length];
            st = new StringTokenizer(br.readLine());
            maxNode = 0;
            for (int i = 0; i < length; i++) {
                edgeData[i] = Integer.parseInt(st.nextToken());
                maxNode = Math.max(maxNode, edgeData[i]);
            }

            // 인접행렬 초기화
            matrix = new int[maxNode + 1][maxNode + 1];

            // 간선 데이터 추가 (중복 간선 허용 방지)
            for (int i = 0; i < length; i += 2) {
                int from = edgeData[i];
                int to = edgeData[i + 1];

                matrix[from][to] = 1;
            }

            visited = new boolean[maxNode + 1];

            // BFS 탐색
            int result = bfs(start);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        int maxDepth = 0;
        int maxNodeAtMaxDepth = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentNode = current[0];
            int currentDepth = current[1];

            // 최대 깊이 및 노드 갱신
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
                maxNodeAtMaxDepth = currentNode;
            } else if (currentDepth == maxDepth && currentNode > maxNodeAtMaxDepth) {
                maxNodeAtMaxDepth = currentNode;
            }

            for (int i = 1; i <= maxNode ; i++) {
                if (matrix[currentNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new int[]{i, currentDepth + 1});
                }
            }
        }
        return maxNodeAtMaxDepth;
    }
}