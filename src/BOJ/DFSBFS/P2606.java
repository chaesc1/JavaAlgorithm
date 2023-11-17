package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2606 {
    static int num;
    static int count = 0;
    static int[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        arr = new int[num+1][num+1];
        check = new boolean[num+1];
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = arr[to][from] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        check[start] = true;

        for (int i = 0; i <= num; i++) {
            if (!check[i] && arr[start][i] == 1) {
                count++;
                dfs(i);
            }
        }
    }
}
