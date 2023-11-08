package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] oper = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int number, int depth) {
        if (depth == N) {
            MAX = Math.max(number, MAX);
            MIN = Math.min(number, MIN);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                switch (i) {
                    case 0:
                        dfs(number+arr[depth],depth+1);
                        break;
                    case 1:
                        dfs(number-arr[depth],depth+1);
                        break;
                    case 2:
                        dfs(number*arr[depth],depth+1);
                        break;
                    case 3:
                        dfs(number/arr[depth],depth+1);
                        break;
                }

                oper[i]++;
            }
        }
    }
}
