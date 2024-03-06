import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);

        solve(len, r, c);
        System.out.println(answer);
    }

    private static void solve(int length, int r, int c) {
        if (length == 1) {
            return;
        }
        if (r < length / 2 && c < length / 2) {
            solve(length / 2, r, c);
        } else if (r < length / 2 && c >= length / 2) { // 2사분면
            //1사분면을 지나야 한다
            answer += (length * length) / 4;
            solve(length / 2, r, c - length / 2);
        } else if (r >= length / 2 && c < length / 2) {
            //1,2 사분면 지나야해
            answer += ((length * length) / 4) * 2;
            solve(length / 2, r - length / 2, c);

        } else {
            answer += ((length * length) / 4) * 3;
            solve(length / 2, r - length / 2, c - length / 2);
        }
    }
}
