package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken()) - 1;

        int[] map = new int[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        //도형의 밑변에 빈칸을 배열로
        int[][][] tetris = {
                {{0}, {0, 0, 0, 0}},
                {{0, 0}},
                {{0, 0, 1}, {1, 0}},
                {{1, 0, 0}, {0, 1}},
                {{0, 0, 0}, {1, 0}, {1, 0, 1}, {0, 1}},
                {{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}},
                {{0, 0, 0}, {0, 2}, {1, 1, 0}, {0, 0}}
        };
        int answer = 0;
        for (int i = 0; i < tetris[P].length; i++) {
            for (int j = 0; j < C - tetris[P][i].length + 1; j++) {
                int diff = map[j] - tetris[P][i][0];
                boolean isOk = true;
                for (int k = 1; k < tetris[P][i].length; k++) {
                    if (diff != map[j + k] - tetris[P][i][k]) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
