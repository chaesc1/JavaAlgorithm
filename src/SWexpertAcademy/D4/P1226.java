package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1226 {
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int destX, destY, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            map = new int[16][16];
            isVisited = new boolean[16][16];
            for (int i = 0; i < 16; i++) {
                String input = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        destX = j;
                        destY = i;
                    }
                }
            }
            answer = 0;
            isVisited[destY][destX] = true;
            dfs(destX, destY);

            System.out.println("#" + t + " " + answer);
        }
    }

    public static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[ny][nx] == 3) { // 도착점에서 시작점으로 갈 수 있다면
                answer = 1;
                return;
            }
            if (nx >= 1 && nx < 16 && ny >= 0 && ny < 16) {
                if (!isVisited[ny][nx] && map[ny][nx] != 1) {
                    isVisited[ny][nx] = true;
                    dfs(nx,ny);
                }
            }
        }

    }
}
