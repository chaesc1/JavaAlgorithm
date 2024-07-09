package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    static int N, M, res;
    static boolean[] visited;
    static HashMap<Integer, Integer> info;

    static class Node {
        int pos;
        int steps;

        public Node(int pos, int steps) {
            this.pos = pos;
            this.steps = steps;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리수
        M = Integer.parseInt(st.nextToken()); // 뱀 수

        info = new HashMap<>();
        // 사다리 정보 - start < end 위로 올라가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 뱀 정보 - start > end 아래로 내려가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            info.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        visited = new boolean[101];
        bfs(1); // 1번 칸 부터 시작
    }

    private static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.pos == 100) {
                System.out.println(node.steps);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int nextPos = node.pos + i;

                if (nextPos > 100 || visited[nextPos]) continue;

                visited[nextPos] = true;
                if (info.containsKey(nextPos)) {
                    nextPos = info.get(nextPos);
                }
                q.add(new Node(nextPos, node.steps + 1));
            }
        }
    }
}
