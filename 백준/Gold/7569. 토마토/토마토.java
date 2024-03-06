import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int MIN = Integer.MIN_VALUE;
    static int[][][] tomato;
    static Queue<int[]> queue;

    //정수 1은 익은 토마토,
    // 정수 0 은 익지 않은 토마토,
    // 정수 -1은 토마토가 들어있지 않은 칸
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        queue = new LinkedList<>();
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        x = k;
                        y = j;
                        z = i;
                        queue.add(new int[]{x, y, z});
                    }
                }
            }
        }

        System.out.println(bfs(x, y, z));
    }

    private static int bfs(int x, int y, int z) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                int nz = temp[2] + dz[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                    if (tomato[nz][ny][nx] == 0) {
                        queue.add(new int[] {nx,ny,nz});
                        tomato[nz][ny][nx] = tomato[temp[2]][temp[1]][temp[0]] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) return -1;
                    MIN = Math.max(MIN,tomato[i][j][k]);
                }
            }
        }
        if (MIN == 1) {
            return 0;
        } else {
            return MIN - 1;
        }
    }
}
