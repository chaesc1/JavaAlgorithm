import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static class House {
        int x, y;

        public House(int x, int y) {
            this.x = x; 
            this.y = y; 
        }
    }

    static int N, M; // N: 도시 크기, M: 하나의 집이 지불하는 수익
    static int max; // 최대 방범 서비스를 받을 수 있는 집의 수
    static int[][] map; // 도시 맵
    static Set<String> houses; // 집의 위치를 저장하는 집합
    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= TC; tc++) {
            // 도시 크기(N)와 하나의 집이 지불하는 수익(M) 입력 받음
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N]; // 도시 맵 초기화
            houses = new HashSet<>(); // 집 위치 저장을 위한 집합 초기화

            // 지도 정보를 입력받음
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        houses.add(i + "," + j); // 집 위치를 집합에 저장
                    }
                }
            }

            max = Integer.MIN_VALUE; // 최대값 초기화
            // K의 값을 1부터 N+1까지 시도 (최대 운영 범위)
            for (int k = 1; k <= N + 1; k++) {
                int operationCost = getOperation(k); // 운영 비용 계산
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        solve(i, j, k, operationCost); // 각 좌표를 중심으로 방범 서비스 적용
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n"); // 결과 저장
        }
        System.out.println(sb.toString()); // 결과 출력
    }

    /**
     * 주어진 중심 좌표 (x, y)와 k 범위 내에서 방범 서비스를 제공하여 수익을 계산
     */
    private static void solve(int x, int y, int k, int operationCost) {
        int houseCount = 0; // 범위 내의 집 개수

        // K 범위 내 모든 좌표 탐색
        for (int i = x - k + 1; i <= x + k - 1; i++) {
            for (int j = y - k + 1; j <= y + k - 1; j++) {
                if (Math.abs(x - i) + Math.abs(y - j) < k && isValid(i, j)) {
                    houseCount++; // 집이 있으면 개수 증가
                }
            }
        }

        // 수익 계산
        int profit = (houseCount * M) - operationCost;
        if (profit >= 0) {
            max = Math.max(max, houseCount); // 최대 값 갱신
        }
    }

    /**
     * 주어진 좌표 (x, y)가 유효한지 확인
     */
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && houses.contains(x + "," + y);
    }

    /**
     * K 값에 따른 운영 비용 계산
     */
    private static int getOperation(int k) {
        return k * k + (k - 1) * (k - 1);
    }
}