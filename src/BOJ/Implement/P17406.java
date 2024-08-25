package BOJ.Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17406 {
    static class SpinInfo {
        int r, c, s;

        public SpinInfo(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static int N, M, K;
    static int[][] arr;
    static int[][] copyArr;
    static int minA = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int[] result;
    static SpinInfo[] spinInfos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copyArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        spinInfos = new SpinInfo[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            spinInfos[i] = new SpinInfo(r, c, s);
        }

        isVisited = new boolean[K];
        result = new int[K];
        permutation(0);

        System.out.println(minA);
    }

    private static void permutation(int cnt) {
        if (cnt == K) {
            copyMap(); // 배열 복사
            for (int i = 0; i < K; i++) {
                rotate(spinInfos[result[i]].r, spinInfos[result[i]].c, spinInfos[result[i]].s);
            }
            getMinValue();  // 최솟값 계산
            return;
        }

        for (int i = 0; i < K; i++) {
            if (isVisited[i]) continue;

            result[cnt] = i;
            isVisited[i] = true;
            permutation(cnt + 1);
            isVisited[i] = false;
        }
    }

    private static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
    }

    private static void rotate(int r, int c, int s) {
        for (int i = 1; i <= s; i++) {
            int startX = r - i - 1;
            int startY = c - i - 1;
            int endX = r + i - 1;
            int endY = c + i - 1;

            int temp = copyArr[startX][startY];

            // 왼쪽 → 오른쪽
            for (int j = startY; j < endY; j++) {
                copyArr[startX][j] = copyArr[startX][j + 1];
            }
            // 위 → 아래
            for (int j = startX; j < endX; j++) {
                copyArr[j][endY] = copyArr[j + 1][endY];
            }
            // 오른쪽 → 왼쪽
            for (int j = endY; j > startY; j--) {
                copyArr[endX][j] = copyArr[endX][j - 1];
            }
            // 아래 → 위
            for (int j = endX; j > startX; j--) {
                copyArr[j][startY] = copyArr[j - 1][startY];
            }

            copyArr[startX + 1][startY] = temp;
        }
    }

    private static void getMinValue() {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copyArr[i][j];
            }
            minA = Math.min(minA, sum);
        }
    }
}