import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answer = 0;
        arr = new int[N];
        visited = new boolean[N];

        backTracking(0);

        System.out.println(sb.toString());
    }

    private static void backTracking(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            arr[depth] = i + 1;
            visited[i] = true;
            backTracking(depth + 1);
            visited[i] = false;
        }
    }
}
