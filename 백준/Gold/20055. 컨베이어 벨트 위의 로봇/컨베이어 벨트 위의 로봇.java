import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    private static int solve() {
        int level = 0;
        //내구도가 0인 칸의 개수가 K개 이상이라면 종료, 그렇지 않다면? 1번 으로 반복
        while (isTrue()) {
            //1단계 : 밸트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다.
            int tmp = belt[2 * N - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            //가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동 가능하면 이동
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i] = true;
                    belt[i]--;
                    robot[i - 1] = false;
                }
            }

            //단계 3: 올리는 위치의 칸의 내구도가 0이 아니면 해당 위치에 로봇을 올림
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }
            level++;
        }

        return level;
    }

    private static boolean isTrue() {
        int cnt = 0;
        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}
