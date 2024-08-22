import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N; // 방의 크기
    static int max; // 최대 이동한 거리
    static int answerNum; // 시작 방 번호
    static int[][] map; // 방 배열
    static int[][] dp; // 메모이제이션 배열
    static int[] dx = {-1, 1, 0, 0}; // 이동 방향 배열: 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 이동 방향 배열: 상, 하, 좌, 우

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 방의 크기 입력
            map = new int[N][N]; // 방 배열 초기화
            dp = new int[N][N]; // 메모이제이션 배열 초기화

            // 방 배열 값 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 값 초기화
            max = 1; // 최소 길이는 1
            answerNum = Integer.MAX_VALUE; // 최대한 큰 값으로 초기화

            // 모든 위치에서 DFS 탐색 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int dist = dfs(i, j); // DFS 함수 호출
                    if (dist > max) {
                        max = dist;
                        answerNum = map[i][j];
                    } else if (dist == max) {
                        answerNum = Math.min(answerNum, map[i][j]);
                    }
                }
            }
            // 결과 저장
            sb.append("#").append(tc).append(" ").append(answerNum).append(" ").append(max).append("\n");
        }
        // 전체 결과 출력
        System.out.println(sb.toString());
    }

    /**
     * DFS를 이용하여 방을 탐색하는 함수
     *
     * @param x 현재 x 좌표
     * @param y 현재 y 좌표
     * @return 최대 이동 거리
     */
    private static int dfs(int x, int y) {
        // 이미 계산된 값이 있으면 반환
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // 기저 사례: 초기 길이는 1
        int maxDist = 1;

        // 네 방향으로 이동 검사
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵을 벗어나거나 이동할 수 없다면 패스
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            // 이동하려는 방의 번호가 현재 방의 번호 + 1이라면 이동
            if (map[nx][ny] == map[x][y] + 1) {
                maxDist = Math.max(maxDist, 1 + dfs(nx, ny)); // 다음 방으로 이동
            }
        }

        // 현재 위치에서의 최대 이동 거리 저장 (메모이제이션)
        dp[x][y] = maxDist;
        return maxDist;
    }
}