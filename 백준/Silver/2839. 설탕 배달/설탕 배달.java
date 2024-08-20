import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            // N 이 더이상 쪼개지지 않는다면
            if (N < 3) {
                cnt = -1;
                break;
            }

            N -= 3;
            cnt++;
        }
        System.out.println(cnt);
    }
}