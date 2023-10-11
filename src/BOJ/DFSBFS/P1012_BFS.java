package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012_BFS {
    static int N,M,K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N= Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if(map[x][y] == 1 && !visited[x][y]){
                        bfs(x,y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    //bfs 는 queue 사용
    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int []>();
        q.add(new int[] {x,y});

        while (!q.isEmpty()){
            //최 상단 값 빼고
            int[] poll = q.poll();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        q.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
    }
}
