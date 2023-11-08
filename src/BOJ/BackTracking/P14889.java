package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
    static int N;
    static int[][] arr;
    static boolean[] isVisited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0); //인덱스, 조합갯수 (N/2)
        System.out.println(MIN);
    }

    public static void backTracking(int index, int count) {
        if (count == N / 2) {
            //조합 모두 구했으면 차이를 계산하고
            calc();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                backTracking(i + 1, count + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                //i 번째 사람이랑 j 번째 사람이 true 면 스타트팀 점수에 더하고
                if (isVisited[i] && isVisited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(!isVisited[i] && !isVisited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int diff = Math.abs(start - link); // 차이값

        if (diff == 0) {
            MIN = 0;
            System.exit(0);
        }

        MIN = Math.min(MIN,diff);
    }
}
