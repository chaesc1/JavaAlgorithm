package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4193 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int startX, startY, endX, endY, answer;

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 출발지
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            //도착지
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY) {
                System.out.println("#" + tc + " " + 0);
                continue;
            }
            // 최소거리를 구해야해 -> bfs 가 좋아보임

            boolean result = bfs();
            if (result) System.out.println("#" + tc + " " + answer);
            else System.out.println("#" + tc + " " + -1);

        }

    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (nx == endX && ny == endY) {
                    answer = node.time + 1;
                    return true;
                }
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }
                // 소용돌이면
                if (map[nx][ny] == 2) {
                    if (node.time % 3 == 2) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, node.time + 1));
                    } else {
                        // 제자리에서 시간만 흐르게 대기
                        visited[node.x][node.y] = true;
                        q.add(new Node(node.x, node.y, node.time + 1));
                    }
                } else {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, node.time + 1));
                }

            }
        }
        return false;
    }
}
