package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static int L;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] arr;
    static boolean[][] visited;
    static int startX, startY, destX, destY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            //체스판 한변의 길이
            L = Integer.parseInt(br.readLine());
            arr = new int[L][L];
            visited = new boolean[L][L];
            //현재 나이트가 있는 칸 좌표
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            //도착점
            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(arr[destX][destY]).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx >= 0 && nx < L && ny >= 0 && ny < L) {
                    if (!visited[nx][ny]) {
                        queue.add(new int[] {nx,ny});
                        arr[nx][ny] = arr[pos[0]][pos[1]] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
