import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static class Cell {
        int x, y, count, dir;

        public Cell(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }
    }

    static class TempCell {
        int maxCount, count, dir;

        public TempCell(int maxCount, int count, int dir) {
            this.maxCount = maxCount;
            this.count = count;
            this.dir = dir;
        }

        public void reset() {
            this.maxCount = 0;
            this.count = 0;
            this.dir = -1;
        }
    }

    static TempCell[][] tempMap;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    static int N, M, K;
    static LinkedList<Cell> cells;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cells = new LinkedList<>();
            tempMap = new TempCell[N][N];

            // 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tempMap[i][j] = new TempCell(0, 0, -1);
                }
            }

            // 초기 미생물 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                cells.add(new Cell(x, y, count, dir));
            }

            // 격리 시간만큼 진행
            for (int day = 0; day < M; day++) {
                // 임시 맵 초기화
                for (Cell cell : cells) {
                    int nx = cell.x + dx[cell.dir];
                    int ny = cell.y + dy[cell.dir];

                    // 약품 구역이면
                    if (isChem(nx, ny)) {
                        cell.count /= 2;
                        cell.dir = changeDir(cell.dir);
                    }

                    if (tempMap[nx][ny].count == 0) {
                        tempMap[nx][ny].maxCount = cell.count;
                        tempMap[nx][ny].count = cell.count;
                        tempMap[nx][ny].dir = cell.dir;
                    } else {
                        tempMap[nx][ny].count += cell.count;
                        if (cell.count > tempMap[nx][ny].maxCount) {
                            tempMap[nx][ny].maxCount = cell.count;
                            tempMap[nx][ny].dir = cell.dir;
                        }
                    }

                    // 새로운 위치 갱신
                    cell.x = nx;
                    cell.y = ny;
                }

                // 셀 갱신 및 tempMap 초기화
                cells.clear();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tempMap[i][j].count > 0) {
                            cells.add(new Cell(i, j, tempMap[i][j].count, tempMap[i][j].dir));
                            tempMap[i][j].reset();  // 다음날을 위해 초기화
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + cells.stream().mapToInt(cell -> cell.count).sum());
        }
    }

    private static int changeDir(int dir) {
        return dir % 2 == 0 ? dir + 1 : dir - 1;
    }

    private static boolean isChem(int nx, int ny) {
        return nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1;
    }
}