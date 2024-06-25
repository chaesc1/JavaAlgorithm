import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, B, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            dfs(0, 0);
            System.out.println("#" + t + " " + (answer - B));
        }
    }

    private static void dfs(int start, int sum) {
        if (sum >= B) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            if (sum + arr[i] < answer) {
                dfs(i+1, sum+arr[i]);
            }
        }
    }
}
