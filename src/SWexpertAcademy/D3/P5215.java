package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class P5215 {
    static int[][] arr;
    static int N, L, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //재료수 , 제한 칼로리
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            solve(0, 0, 0);

            System.out.println("#"+t+" "+max);
        }
    }

    private static void solve(int score, int cal, int index) {
        //정해진 칼로리를 초과한 경우
        if (cal > L) {
            return;
        }
        //정해진 칼로리보다 작은 경우
        if (cal <= L) {
            max = Math.max(max, score);
        }
        //모든 경우의 수 탐색한 경우 return
        if (index == N) {
            return;
        }

        solve(score + arr[index][0], cal + arr[index][1], index + 1);
        solve(score, cal, index + 1);
    }
}
