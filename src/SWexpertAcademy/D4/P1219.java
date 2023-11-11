package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1219 {
    static int N = 100;
    static int[][] arr;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int test = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
            int len = Integer.parseInt(st.nextToken());// 길이
            result = 0;
            arr = new int[N][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                int idx = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                if (arr[idx][0] == 0) {
                    arr[idx][0] = num;
                } else {
                    arr[idx][1] = num;
                }
            }
            dfs(arr[0][0]);
            dfs(arr[0][1]);

            System.out.println("#"+t+" "+result);
        }
    }
    private static void dfs(int start) {
        if (start == 99) { // 도착점이면?
            result = 1;
            return;
        }
        if (start == 0) {
            return;
        }

        dfs(arr[start][0]);
        dfs(arr[start][1]);
        System.out.println("dfs: "+start);
    }
}
