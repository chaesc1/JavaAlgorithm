import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited, isCheck;

    static int n,res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            res = 0;

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            isCheck = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (isCheck[j]) continue;
                dfs(j);
            }
            System.out.println(n-res);
        }
    }

    private static void dfs(int index) {
        if (isCheck[index]) return;
        if (visited[index]) {
            isCheck[index] = true;
            res++;
        }
        visited[index] = true;
        dfs(arr[index]);
        isCheck[index] = true;
        visited[index] = false;
    }
}