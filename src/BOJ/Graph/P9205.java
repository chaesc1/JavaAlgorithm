package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Point> list;
    static Point sNode, dNode; // 출발, 도착지 노드
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 출발 위치
                if (i == 0) {
                    sNode = new Point(x, y);
                } else if (i == N + 1) {
                    dNode = new Point(x, y);
                } else {
                    list.add(new Point(x, y));
                }
            }
            // 탐색 시작
            bfs();
        }

    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(sNode);

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (Math.abs(now.x - dNode.x) + Math.abs(now.y - dNode.y) <= 1000) {
                System.out.println("happy");
                return;
            }
            // 편의점 방문
            for (int i = 0; i < N; i++) {
                if (!visited[i]) { // 방문하지 않은 편의점이면
                    // 다음 위치
                    Point next = list.get(i);
                    // 현재위치에서 편의점이 1000 미터 이내이면
                    if (Math.abs(now.x - next.x) + Math.abs(now.y - next.y) <= 1000) {
                        visited[i] = true; // 해당 편의점 방문표시하고
                        q.add(next); // 해당 편의점좌표를 큐에 add
                    }
                }
            }
        }
        System.out.println("sad");
        return;
    }
}
