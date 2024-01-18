package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int maxSize = 0;
        int size = 0;
        int pictureCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    maxSize = Math.max(maxSize, Bfs(j,i));
                    pictureCnt++;
                }
            }
        }
        //그림 개수
        System.out.println(pictureCnt);
        //제일 넓은 그림의 칸수
        System.out.println(maxSize);
    }

    private static int Bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx > m-1 || ny < 0 || ny > n-1) {
                    continue;
                }
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 1) {
                    count++;// 덩어리 크기 늘려주고
                    visited[ny][nx] = true;
                    queue.add(new int[] {nx,ny});
                }
            }
        }

        return count;
    }
}
