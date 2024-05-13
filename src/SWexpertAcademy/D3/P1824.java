package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1824 {
    static int R, C;
    static boolean visited[][][][]; // 방향 , 메모리 , 행 , 열
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int check;

    private static class Info {
        int x, y, dir, memory;

        public Info(int x, int y, int dir, int memory) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.memory = memory;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            check = -1;
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                boolean checkStopPoint = false;

                for (int j = 0; j < C; j++) {
                    if (check != -1 || map[i][j] == '@') {
                        checkStopPoint = true;
                    }
                }
                if (checkStopPoint) {
                    check = 0;
                }
            }

            visited = new boolean[4][16][R][C];
            if (check == 0) {
                dfs(new Info(0, 0, 0, 0));
            }

            if (check == 1) {
                System.out.println("#" + tc + " " + "YES");
            } else {
                System.out.println("#" + tc + " " + "NO");
            }
        }
    }

    private static void dfs(Info info) {
        if (check != 0) {
            return;
        }

        //이미 방문한 곳이라면
        if (visited[info.dir][info.memory][info.x][info.y]) {
            return;
        }
        Info newInfo = new Info(info.x, info.y, info.dir, info.memory);
        char now = map[newInfo.x][newInfo.y];

        visited[info.dir][info.memory][info.x][info.y] = true;
        if (now >= '0' && now <= '9') {
            newInfo.memory = now - '0';
        } else if (now == '<') {
            newInfo.dir = 2;
        } else if (now == '>') {
            newInfo.dir = 0; //동쪽
        } else if (now == '^') {
            newInfo.dir = 3;
        } else if (now == 'v') {
            newInfo.dir = 1;
        } else if (now == '_') {
            newInfo.dir = (newInfo.memory == 0) ? 0 : 2;
        } else if (now == '|') {
            newInfo.dir = (newInfo.memory == 0) ? 1 : 3;
        } else if (now == '?') {
            for (int i = 0; i < 4; i++) {
                int nDir = (newInfo.dir + i) % 4;

                int nx = newInfo.x + dx[nDir];
                int ny = newInfo.y + dy[nDir];

                if (nx < 0) {
                    nx = R - 1;
                } else if (nx >= R) {
                    nx = 0;
                } else if (ny < 0) {
                    ny = C - 1;
                } else if (ny >= C) {
                    ny = 0;
                }

                dfs(new Info(nx, ny, nDir, newInfo.memory));
            }
            return;
        } else if (now == '@') {
            check = 1;
        } else if (now == '+') {
            newInfo.memory = (newInfo.memory == 15) ? 0 : newInfo.memory + 1;
        } else if (now == '-') {
            newInfo.memory = (newInfo.memory == 0) ? 15 : newInfo.memory - 1;
        }

        newInfo.x += dx[newInfo.dir];
        newInfo.y += dy[newInfo.dir];

        if (newInfo.x < 0) {
            newInfo.x = R - 1;
        } else if (newInfo.x >= R) {
            newInfo.x = 0;
        } else if (newInfo.y < 0) {
            newInfo.y = C - 1;
        } else if (newInfo.y >= C) {
            newInfo.y = 0;
        }

        dfs(new Info(newInfo.x,newInfo.y, newInfo.dir, newInfo.memory));
    }
}
