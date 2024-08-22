import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1}; // 위, 가운데, 아래 순서
    static int[] dy = {1, 1, 1}; // 오른쪽으로만 이동
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        // 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 각 행에 대해 파이프 설치 시도
        for (int i = 0; i < R; i++) {
            if (makePipe(i, 0)) {
                max++; // 성공적으로 파이프를 설치한 경우 증가
            }
        }

        System.out.println(max);
    }

    // 파이프를 설치하는 메서드
    private static boolean makePipe(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 3; i++) { // 우상, 우, 우하 순서로 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 확인 및 방문 체크
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (map[nx][ny] == 'x' || visit[nx][ny]) continue;

            // 오른쪽 끝에 도달하면 true 반환
            if (ny == C - 1) {
                return true;
            }

            // 다음 칸으로 재귀적으로 탐색
            if (makePipe(nx, ny)) {
                return true;
            }
        }

        return false;
    }
}