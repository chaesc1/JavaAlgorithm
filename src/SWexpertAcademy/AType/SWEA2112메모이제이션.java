package SWexpertAcademy.AType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA2112메모이제이션 {
    static int D, W, K;
    static int[][] map;
    static int result;
    static Map<String, Integer> memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;

            map = new int[D][W];
            memo = new HashMap<>();
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0, 0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int index, int cnt) {
        if (cnt >= result) {
            return;
        }

        // 조건이 만족되면 최적 결과 갱신
        if (isOk()) {
            result = Math.min(cnt, result);
            return;
        }

        if (index == D) {
            return;
        }

        // 메모이제이션 키 생성
        String key = generateKey(index, cnt);
        if (memo.containsKey(key) && memo.get(key) <= cnt) {
            return;
        }

        memo.put(key, cnt);

        int[] col = map[index].clone();

        // 약품 처리 안함
        solve(index + 1, cnt);

        // A 처리
        fillRow(index, 0);
        solve(index + 1, cnt + 1);

        // B 처리
        fillRow(index, 1);
        solve(index + 1, cnt + 1);

        // 원상복구
        map[index] = col;
    }

    private static String generateKey(int index, int cnt) {
        StringBuilder sb = new StringBuilder();
        sb.append(index).append(cnt);
        for (int i = 0; i < W; i++) {
            sb.append(map[index][i]);
        }
        return sb.toString();
    }

    private static void fillRow(int row, int value) {
        for (int i = 0; i < W; i++) {
            map[row][i] = value;
        }
    }

    private static boolean isOk() {
        for (int i = 0; i < W; i++) {
            int count = 1;
            boolean valid = false;

            for (int j = 1; j < D; j++) {
                if (map[j][i] == map[j - 1][i]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= K) {
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                return false;
            }
        }
        return true;
    }
}