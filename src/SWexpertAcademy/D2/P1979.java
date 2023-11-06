package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            //행 탐색
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) {
                        if (cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                if (cnt == K) {
                    answer++;
                }
            }
            //열 탐색
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 0) {
                        if (cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                if (cnt == K) {
                    answer++;
                }
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
}
