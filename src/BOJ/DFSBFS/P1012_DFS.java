package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유기농 배추
//입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
// 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
// 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어
public class P1012_DFS {
    static int N,M,K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());


            map = new int[M][N];
            visited = new boolean[M][N];
            K = Integer.parseInt(st.nextToken());
            //양배추 심어
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    //양배추 심은 곳 이거나 방문하지 않았다면?
                    if (map[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N){
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }
}
