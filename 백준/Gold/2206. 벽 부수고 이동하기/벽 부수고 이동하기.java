import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visitied; // 좌표 방문처리 , 벽 부순거 체크
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visitied = new boolean[2][N][M];

        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }

        int[][] dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        // x, y, crush
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int curY = now[1];
            int crush = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                //check valid
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                //벽이면 crush
                if (map[nx][ny] == 1) {
                    //부순적이 없고, 방문하지 않았다면
                    if (crush == 0 && !visitied[1][nx][ny]) {
                        visitied[crush][nx][ny] = true;
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.add(new int[]{nx, ny, 1});
                    }
                } else {
                    if (!visitied[crush][nx][ny]) {
                        visitied[crush][nx][ny] = true;
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.add(new int[]{nx, ny, crush});
                    }
                }

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(dist[nx][ny] + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
