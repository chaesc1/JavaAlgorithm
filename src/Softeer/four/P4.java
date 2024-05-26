package Softeer.four;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[] directions = {'2', '1', '8', '4'}; // 상, 하, 좌, 우의 방향을 나타내는 문자

    static int N;
    static char[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
    }

    void expand(int[][] grid, int round) {
        int n = grid.length, m = grid[0].length;
        int[][] nextGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || Character.isUpperCase(grid[i][j]))
                    continue;
                for (int dir = 0; dir < 4; dir++) {
                    if ((grid[i][j] & directions[dir]) > 0)
                        continue;
                    int x = i + dx[dir];
                    int y = j + dy[dir];
                    if (x < 0 || x >= n || y < 0 || y >= m || Character.isUpperCase(grid[x][y]))
                        continue;
                    nextGrid[x][y] += round;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isUpperCase(grid[i][j])) {
                    int country = grid[i][j];
                    int numberOfAreas = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];
                        if (x < 0 || x >= n || y < 0 || y >= m || nextGrid[x][y] != round ||
                                (grid[x][y] > 0 && (grid[x][y] & directions[dir]) > 0))
                            continue;
                        if (nextGrid[x][y] == round * 2) {
                            grid[x][y] = 0;
                        } else {
                            grid[x][y] = country;
                        }
                    }
                }
            }
        }
    }
}
