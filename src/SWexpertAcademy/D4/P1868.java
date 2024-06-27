package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1868 {
    static int N, answer, mineCnt;
    static int[][] mine;
    static char[][] map;
    static boolean[][] visited;
    // 8방 탐색해야해
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            mine = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            answer = 0;
            // 주변에 지뢰가 있는지 체크
            // 주변에 지뢰가 없는걸 먼저 눌러줘
            // 주변에 지뢰가 하나라도 있는 칸을 눌러
            countMine();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] == 0 && map[i][j] != '*' && !visited[i][j]) {
                        click(i, j);
                        answer++; //클릭 횟수 늘려
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] > 0 && map[i][j] != '*'&& !visited[i][j]) {
                        answer++; //클릭 횟수 늘려
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void click(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        mine[x][y] = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위를 벗어나거나 , 이미 방문 , 다음 구역이 지뢰라면
                if (!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }
                if (mine[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                }
                visited[nx][ny] = true;
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void countMine() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (map[nx][ny] == '*') {
                                count++;
                            }
                        }
                    }
                    mine[i][j] = count;
                }
            }
        }
    }
}
