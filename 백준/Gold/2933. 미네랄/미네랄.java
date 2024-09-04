import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> shoot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        // 맵 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = Integer.parseInt(br.readLine());
        shoot = new ArrayList<>();

        // 막대 던지는 높이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            shoot.add(Integer.parseInt(st.nextToken()));
        }

        // 막대 던지기
        for (int i = 0; i < shoot.size(); i++) {
            int height = R - shoot.get(i);    // 높이는 아래에서 올라오는 구조이므로 R - height
            if (i % 2 == 0) {
                // 왼쪽에서 던지기
                for (int j = 0; j < C; j++) {
                    if (map[height][j] == 'x') {
                        map[height][j] = '.'; // 미네랄 파괴
                        break;
                    }
                }
            } else {
                // 오른쪽에서 던지기
                for (int j = C - 1; j >= 0; j--) {
                    if (map[height][j] == 'x') {
                        map[height][j] = '.'; // 미네랄 파괴
                        break;
                    }
                }
            }

            // 클러스터 확인 및 떨어뜨리기
            dropCluster();
        }

        // 결과 출력
        printMap();
    }

    // 맵 출력하는 함수
    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    // 클러스터 확인 및 떨어뜨리는 함수
    private static void dropCluster() {
        boolean[][] visited = new boolean[R][C];
        ArrayList<int[]> floatingClusters = new ArrayList<>();

        // 바닥과 연결된 클러스터들을 방문 표시
        for (int j = 0; j < C; j++) {
            if (map[R - 1][j] == 'x' && !visited[R - 1][j]) {
                dfs(R - 1, j, visited);
            }
        }

        // 공중에 떠 있는 클러스터를 찾는 과정
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    floatingClusters.add(new int[]{i, j});
                    map[i][j] = '.'; // 잠시 제거
                }
            }
        }

        if (floatingClusters.isEmpty()) {
            return;
        }

        // 공중에 떠 있는 클러스터를 아래로 내려놓기
        boolean drop = true;
        while (drop) {
            for (int[] cluster : floatingClusters) {
                int ny = cluster[0] + 1;
                int nx = cluster[1];
                if (ny >= R || (map[ny][nx] == 'x' && visited[ny][nx])) {
                    drop = false;
                    break;
                }
            }
            if (drop) {
                for (int i = 0; i < floatingClusters.size(); i++) {
                    floatingClusters.get(i)[0]++;
                }
            }
        }

        // 클러스터를 새로운 위치에 다시 놓기
        for (int[] cluster : floatingClusters) {
            map[cluster[0]][cluster[1]] = 'x';
        }
    }

    // DFS로 클러스터를 탐색하는 함수
    private static void dfs(int x, int y, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'x' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
}