package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1249 {
    static int[][] isChecked;
    static int[][] map;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int min = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            isChecked = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] st = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(st[j]));
                    isChecked[i][j] = Integer.MAX_VALUE;
                }
            }
            isChecked[0][0] = map[0][0];
            bfs();
            System.out.println("#"+t+" "+isChecked[N-1][N-1]);
        }
    }

    private static void bfs() {
        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int[] {0,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (isChecked[nx][ny] > isChecked[cur[0]][cur[1]] + map[nx][ny]) {
                        isChecked[nx][ny] = isChecked[cur[0]][cur[1]] + map[nx][ny];
                        pq.offer(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
