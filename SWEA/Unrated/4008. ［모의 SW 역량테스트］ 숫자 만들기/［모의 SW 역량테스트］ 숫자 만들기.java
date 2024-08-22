import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] op;
    static int[] num;
    static int[] expression; // 수식
    static int max;
    static int min;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            op = new int[4];
            num = new int[N];
            expression = new int[N - 1];

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            // 각 연산자의 개수 '+' 2 개, '-' 1 개, '*' 0 개, '/' 1 개
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            // 연산자 소비
            consumeOp(0);
            int result = max - min;

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void consumeOp(int cnt) {
        if (cnt == N - 1) {
            // 연산자 모두 끼워넣었으면
            calc(); // 계산
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;

            op[i]--;
            expression[cnt] = i; // + : 0 , - : 1 , * : 2, / : 3
            consumeOp(cnt + 1);
            op[i]++;
        }
    }

    private static void calc() {
        int value = num[0];
        for (int i = 0; i < N - 1; i++) {
            switch (expression[i]) {
            case 0:
                value += num[i + 1];
                break;
            case 1:
                value -= num[i + 1];
                break;
            case 2:
                value *= num[i + 1];
                break;
            case 3:
                value /= num[i + 1];
                break;
            }
        }
        max = Math.max(max, value);
        min = Math.min(min, value);
    }
}