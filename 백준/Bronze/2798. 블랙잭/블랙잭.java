import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    static int answer = 0;
    static int sum = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,0);
        System.out.println(answer);
    }

    private static void backTracking(int depth, int num) {
        if (depth == 3) {
            if (sum <= m) {
                answer = Math.max(answer, sum);
            }
            return;
        }

        for (int i = num; i < n; i++) {
            sum += arr[i];
            backTracking(depth+1, i+1);
            sum -= arr[i];
        }
    }
}