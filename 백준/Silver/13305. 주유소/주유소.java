import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //거리
        long[] distance = new long[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        //리터당 가격
        long[] prices = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min_price = prices[0];
        for (int i = 0; i < distance.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            sum += (min_price * distance[i]);
        }
        System.out.println(sum);
    }
}
