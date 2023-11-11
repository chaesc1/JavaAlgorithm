package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1227 {
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int startX, startY, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            map = new int[100][100];
            isVisited = new boolean[100][100];

            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

                    if (map[i][j] == 2) {
                        startX = j;
                        startY = i;
                    }
                }
            }
            answer = 0;
            sb.append("#"+t+" ");
            dfs(startX, startY);

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int x, int y) {
        isVisited[y][x] = true;
        if (answer == 1) {
            return;
        }
        if (map[y][x] == 3) {
            answer = 1;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                if (!isVisited[ny][nx] && map[ny][nx] != 1) {
                    dfs(nx,ny);
                }
            }
        }
    }
}
