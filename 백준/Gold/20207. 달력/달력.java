import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[366]; // 1년은 365일

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                day[j]++;
            }
        }

        int sum = 0;
        int maxHeight = 0;
        int width = 0;

        for (int i = 0; i < day.length; i++) {
            if (day[i] == 0) {
                sum += width * maxHeight;
                maxHeight = 0;
                width = 0;
                continue;
            }
            width++;
            maxHeight  = Math.max(maxHeight, day[i]);
        }
        sum += width * maxHeight;
        System.out.println(sum);
    }
}
