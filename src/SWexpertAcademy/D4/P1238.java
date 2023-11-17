package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//비상 연락망
// bfs 너비 우선 탐색 이용하면 solve 가능??

public class P1238 {
    static int[][] graph;
    static int[] visited;//노드번호로 방문표시.
    static int length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("#");
        for (int tc = 1; tc <= 10; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new int[101][101];
            visited = new int[101]; // 1번 ~ 100번 번호 지정.

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = 1;
            }
            int answer = bfs(start); // 시작점으로 부터 너비 우선 탐색 시작.

            sb.append("#"+tc+" "+answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        int depth = 1;
        visited[start] = 1; // 체크

        while (!queue.isEmpty()) {
            start = queue.poll();

            for (int i = 0; i < 101; i++) {
                if (graph[start][i] == 1 && visited[i] == 0) {
                    //서로 연결 되어 있거나 , 방문하지 않은 곳이라면
                    visited[i] = visited[start] + 1;
                    queue.offer(i); // 해당 번호 큐에 삽입
                    // 방문 표시와 함께 이때 visited 의 index 는 node 의 번호
                }
            }
            depth = Math.max(depth,visited[start]);
        }

        for (int i = 100; i >= 0; i--) {
            if (depth == visited[i]) { // 뒤에서부터 탐색해서 제일 먼저 찾는 것이 최대 노드 번호
                return i;
            }
        }

        return -1;
    }
}
