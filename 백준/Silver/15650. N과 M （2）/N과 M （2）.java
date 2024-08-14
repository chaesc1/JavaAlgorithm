import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isSelected = new boolean[n+1];

        backTracking(0,0);
        System.out.println(sb.toString());
    }

    private static void backTracking(int depth,int num) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isSelected[i] && num < i){
                isSelected[i] = true;
                arr[depth] = i;
                backTracking(depth+1,i);
                isSelected[i] = false;
            }
        }
    }
}