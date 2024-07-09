package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13460 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    // 0 1 2 3 -> 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Ball {
        int rx, ry;
        int bx, by;
        int cnt;

        public Ball(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    static Ball red;
    static Ball blue;
    static int endX, endY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        // map 입력 받아
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'O') {
                    endX = i;
                    endY = j;
                } else if (map[i][j] == 'R') {
                    red = new Ball(i, j, 0, 0, 0);
                } else if (map[i][j] == 'B') {
                    blue = new Ball(0, 0, i, j, 0);
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Ball> q = new LinkedList<>();
        q.add(new Ball(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while (!q.isEmpty()) {
            Ball now = q.poll();
            int nowRedX = now.rx;
            int nowRedY = now.ry;
            int nowBlueX = now.bx;
            int nowBlueY = now.by;
            int nowCount = now.cnt;

            if (nowCount > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nextRedX = nowRedX;
                int nextRedY = nowRedY;
                int nextBlueX = nowBlueX;
                int nextBlueY = nowBlueY;

                boolean redFlag = false;
                boolean blueFlag = false;

                while (map[nextRedX + dx[i]][nextRedY + dy[i]] != '#') {
                    nextRedX += dx[i];
                    nextRedY += dy[i];
                    if (nextRedX == endX && nextRedY == endY) {
                        redFlag = true;
                        break;
                    }
                }

                while (map[nextBlueX + dx[i]][nextBlueY + dy[i]] != '#') {
                    nextBlueX += dx[i];
                    nextBlueY += dy[i];
                    if (nextBlueX == endX && nextBlueY == endY) {
                        blueFlag = true;
                        break;
                    }
                }

                if (blueFlag) {
                    continue;
                }
                if (redFlag) {
                    return nowCount;
                }
                if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                    if (i == 0) {
                        // 상
                        if (nowRedX > nowBlueX) {
                            nextRedX -= dx[i];
                        } else {
                            nextBlueX -= dx[i];
                        }
                    } else if (i == 1) {
                        // 하
                        if (nowRedX < nowBlueX) {
                            nextRedX -= dx[i];
                        } else {
                            nextBlueX -= dx[i];
                        }
                    } else if (i == 2) {
                        // 좌
                        if (nowRedY > nowBlueY) {
                            nextRedY -= dy[i];
                        } else {
                            nextBlueY -= dy[i];
                        }
                    } else if (i == 3) {
                        // 우
                        if (nowRedY < nowBlueY) {
                            nextRedY -= dy[i];
                        } else {
                            nextBlueY -= dy[i];
                        }
                    }
                }
                if (!visited[nextRedX][nextRedY][nextBlueX][nextBlueY]) {
                    visited[nextRedX][nextRedY][nextBlueX][nextBlueY] = true;
                    q.add(new Ball(nextRedX, nextRedY, nextBlueX, nextBlueY, nowCount + 1));
                }
            }
        }
        return -1;
    }
}
