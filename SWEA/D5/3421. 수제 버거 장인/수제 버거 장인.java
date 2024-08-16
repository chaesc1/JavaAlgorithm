import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;    //재료의 개수
    static int M;    //유효하지 않은 쌍의 개수

    static boolean[] isSelected;    //햄버거 재료로 선택된 것 체크
    static boolean[][] impossible;
    static int cnt;            //가능한 햄버거 종류 수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            isSelected = new boolean[N + 1];
            impossible = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                impossible[a][b] = true;
                impossible[b][a] = true;
            }

            cnt = 0;

            solve(1);

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int depth) {
        for (int i = 1; i <= N; i++) {
            //
            if (isSelected[i] && impossible[depth][i]) {
                return false;
            }
        }
        return true;
    }

    private static void solve(int depth) {
        if (depth == N + 1) {
            cnt++;
            return;
        }

        if (isPossible(depth)) {
            isSelected[depth] = true;
            solve(depth + 1);
        }
        isSelected[depth] = false;
        solve(depth + 1);
    }
}