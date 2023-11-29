package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P3 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int w, h;
    static int[][] map;
    static int answer = 0;
    static ArrayList<Integer> count;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        w = Integer.parseInt(br.readLine());
        h = Integer.parseInt(br.readLine());

        map = new int[h][w];
//        StringTokenizer st;
        for (int i = 0; i < h; i++) {
            String row = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

//        List<Integer> areas = calculateLakeAreas(); // 호수면적탐색.
//        areas.sort(Collections.reverseOrder()); //내림차슌 정렬
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < areas.size(); i++) {
//            System.out.println(areas.get(i));
//        }
        count = new ArrayList<>(); // 카운트 담을 array
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    answer++;
                    count.add(dfs2(i,j));
                }
            }
        }

        count.sort(Comparator.naturalOrder());
        System.out.println(answer);
        for(int i : count){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static List<Integer> calculateLakeAreas() {
        int m = map.length;
        if (m == 0) return Collections.emptyList();
        int n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j] && isSurroundedByWater(i, j)) {
                    int area = dfs(i, j, visited);
                    areas.add(area);
                }
            }
        }
        return areas;
    }

    static boolean isSurroundedByWater(int x, int y) {
        int m = map.length;
        int n = map[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if (map[x][y] == 1) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                return false;
            }

            if (map[nx][ny] == 1) {
                return true;
            }
        }
        return false;
    }

    public static int dfs2(int curX ,int curY) {
        map[curX][curY] = 0;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {

            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny <h && map[nx][ny] == 1) {
                map[nx][ny] = 0; // 방문처리
                cnt+=dfs2(nx,ny);
            }
        }
        return cnt;
    }
    static int dfs(int x, int y, boolean[][] visited) {
        int m = map.length;
        int n = map[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 1 || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            area += dfs(nx, ny, visited);
        }
        return area;
    }
}