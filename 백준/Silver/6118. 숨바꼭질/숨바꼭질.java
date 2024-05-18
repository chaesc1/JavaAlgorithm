import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //그래프 양방향 연결
            graph[start].add(end);
            graph[end].add(start);
        }

        // 너비탐색으로 제일 거리가 먼 위치 탐색
        // 1번 부터 시작
        bfs(1);
        //첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다), 두 번째는 그 헛간까지의 거리를, 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수
    }

    private static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);
        visited[now] = true;
        int[] count = new int[N+1]; // 거리정보를 담을 배열

        while (!q.isEmpty()) {
            now = q.poll();
            // 현재 노드와 인접한 노드 전부탐색
            for (int index  : graph[now]) {
                if (!visited[index])  {
                    q.offer(index);
                    visited[index] = true;
                    count[index] = count[now] + 1; // 현재 거리에서 더해
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int index = 0; // 인덱스
        int maxCount = 1; // 헛간 개수
        for (int i = 0; i <= N; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
                maxCount = 1;
            } else if (count[i] == max){
                maxCount++;
            }
        }
        System.out.println(index + " " + count[index] + " " + maxCount);
    }
}
