import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

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
            int maxNode = 0;
            for (int i = 0; i < length; i++) {
                edgeData[i] = Integer.parseInt(st.nextToken());
                maxNode = Math.max(maxNode, edgeData[i]);
            }

            // 인접리스트 초기화
            list = new ArrayList[maxNode + 1];
            for (int i = 0; i <= maxNode; i++) {
                list[i] = new ArrayList<>();
            }

            // 간선 데이터 추가 (중복 간선 허용 방지)
            for (int i = 0; i < length; i += 2) {
                int from = edgeData[i];
                int to = edgeData[i + 1];
                if (!list[from].contains(to)) {
                    list[from].add(to);
                }
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

            for (int next : list[currentNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, currentDepth + 1});
                }
            }
        }
        return maxNodeAtMaxDepth;
    }
}