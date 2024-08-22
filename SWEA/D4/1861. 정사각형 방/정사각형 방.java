import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
public class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N,max,answer,s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            answer = 10000;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    s = map[i][j];
                    solve(i, j, 1);
                }
            }

            System.out.println("#"+tc+" "+answer+" "+max);
        }
    }

    private static void solve(int start, int end, int depth) {
        visited[start][end] = true;

        for (int i = 0; i < 4; i++) {
            int ny = start + dy[i];
            int nx = end + dx[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (map[ny][nx] == map[start][end] + 1 && !visited[ny][nx]) {
                solve(ny,nx,depth+1);
            }
        }

        if (depth > max) {
            max = depth;
            answer = s;
        }
        if (depth == max) answer = Math.min(answer,s);

        visited[start][end] = false;
    }
}
