package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int h, w;
    static char[][] map;
    static int[][] dist; // 추가: 각 위치까지의 거리를 저장할 배열
    static Queue<int[]> fire;
    static Queue<int[]> man;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()); // 가로
            w = Integer.parseInt(st.nextToken()); // 세로

            int sx = 0, sy = 0;
            map = new char[w][h];
            dist = new int[w][h]; // 추가: 거리를 저장하는 배열 초기화
            man = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < w; i++) {
                String line = br.readLine();
                for (int j = 0; j < h; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        // 상근이의 시작 위치
                        sx = j;
                        sy = i;
                        man.offer(new int[] { sx, sy });
                        dist[sy][sx] = 1; // 상근이의 위치에서부터의 거리는 1
                    } else if (map[i][j] == '*') {
                        // 불 위치를 큐에 넣어서 관리
                        fire.offer(new int[] { j, i });
                    }
                }
            }
            // bfs 수행
            int ans = escape();
            if (ans == 0)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans);
        }
    }

    private static int escape() {
        while (!man.isEmpty()) {
            // 불을 먼저 확산
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] firePos = fire.poll();
                int curX = firePos[0];
                int curY = firePos[1];
                for (int j = 0; j < 4; j++) {
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = '*'; // 불이 이동
                            fire.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
            int manSize = man.size();
            for (int i = 0; i < manSize; i++) {
                int[] manPos = man.poll();
                int curX = manPos[0];
                int curY = manPos[1];
                for (int j = 0; j < 4; j++) {
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        // 상근이가 맵 밖으로 나감->탈출
                        return dist[curY][curX];
                    }
                    if (map[ny][nx] == '.' && dist[ny][nx] == 0) {
                        // 이동 가능하고 아직 방문하지 않은 곳
                        dist[ny][nx] = dist[curY][curX] + 1; // 이전 위치에서 +1된 거리를 저장
                        man.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        // 상근이가 탈출할 수 없는 경우
        return 0;
    }
}
