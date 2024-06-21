package BOJ.Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14891 {

    static int[][] gear;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            operationGear(gearNum, direction);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += Math.pow(2, i) * gear[i][0];
        }
        System.out.println(result);
    }

    private static void operationGear(int gearNum, int direction) {
        // 0 ~ index - 1
        left(gearNum - 1, -direction);

        //index ~ num
        right(gearNum + 1, -direction);
        rotate(gearNum, direction);
    }

    private static void right(int index, int direction) {
        if (index > 3) {
            return;
        }
        // 마주하는 극이 같으면
        if (gear[index][6] == gear[index - 1][2]) {
            return;
        }
        right(index + 1, -direction);
        rotate(index, direction);
    }

    private static void left(int index, int direction) {
        if (index < 0) {
            return;
        }
        // 마주하는 극이 같으면
        if (gear[index][2] == gear[index + 1][6]) {
            return;
        }
        left(index - 1, -direction);
        rotate(index, direction);
    }

    private static void rotate(int index, int direction) {
        if (direction == 1) {
            int tmp = gear[index][7];
            for (int i = 7; i > 0; i--) {
                gear[index][i] = gear[index][i - 1];
            }
            gear[index][0] = tmp;
        } else {
            int tmp = gear[index][0];
            for (int i = 0; i < 7; i++) {
                gear[index][i] = gear[index][i + 1];
            }
            gear[index][7] = tmp;
        }
    }
}
