package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
 * 2. 자신의 물고기보다 작은 물고기만 먹을 수 있다
 * 3. 더 이상 먹을 수 있는 물고기가 없다면 => 엄마 상어에게 도움을 요청
 * 4. 먹을 수 있는 물고기가 많다면 , 거리가 가깝거나, 가장 위에 있거나, 가장 왼쪽에 있는 물고기 순서로 먹음
 * 5. 물고기가 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1씩 증가
 *
 */
public class P16236 {
    // 방향은 상 좌 하 우 순으로
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int[][] map;

    static int sharkRow, sharkCol, N;
    static int sharkSize = 2;
    static int time = 0;
    static int eatCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] cur = null;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    // 아기 상어의 위치
                    sharkRow = i;
                    sharkCol = j;
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        while (sharkMove()) {
            result += time;
        }

        System.out.println(result);

    }

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static boolean sharkMove() {
        time = 0;
        // 먹은 물고기 수가 몸의 크기와 같아지면 몸의 크기 증가
        if (eatCount == sharkSize) {
            eatCount = 0;
            sharkSize++;
        }

        boolean[][] visited = new boolean[N][N];

        Queue<Node> queue = new LinkedList<>();
        // 아기상어의 위치 , 시간을 묶어서 큐에 넣어
        queue.offer(new Node(sharkRow, sharkCol, 0));
        visited[sharkRow][sharkCol] = true;

        int minTime = Integer.MAX_VALUE;
        // 가장 윗줄에 있는지 확인하기 위해서
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node shark = queue.poll();

            if (shark.time >= minTime) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = shark.x + dx[i];
                int ny = shark.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] > sharkSize) {
                    continue;
                }

                // 먹을 수 있는 물고기면
                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    if (nx < minRow) {
                        minRow = nx;
                        minCol = ny;
                        minTime = shark.time + 1;
                    } else if (nx == minRow) {
                        if (ny < minCol) {
                            minCol = ny;
                            minTime = shark.time + 1;
                        }
                    }
                }

                queue.offer(new Node(nx, ny, shark.time + 1));
                visited[nx][ny] = true;
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            return false;
        } else {
            sharkRow = minRow;
            sharkCol = minCol;
            eatCount++;
            time = minTime;
            map[sharkRow][sharkCol] = 0;
            return true;
        }
    }
}
