import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] taste;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        isSelected = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        // 모든 맛의 조합을 구하고 최소를 구한다
        result = Integer.MAX_VALUE;
        subset(0);
        System.out.println(result);
    }

    private static void subset(int depth) {
        if (depth == N) {
            result = Math.min(result, getDiff());
            return;
        }

        isSelected[depth] = true;
        subset(depth + 1);

        isSelected[depth] = false;
        subset(depth + 1);
    }

    private static int getDiff() {
        int sum1 = 1; // 신맛
        int sum2 = 0; // 쓴맛
        boolean flag = false;// 적어도 하나의 재료가 선택 되었는지 체크
        for (int i = 0; i < N; i++) {
            if (isSelected[i]) {
                flag = true;
                sum1 *= taste[i][0];
                sum2 += taste[i][1];
            }
        }
        if (!flag) return Integer.MAX_VALUE;
        return Math.abs(sum1 - sum2);
    }
}