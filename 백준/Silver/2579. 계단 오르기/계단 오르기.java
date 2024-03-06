import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//계단의 개수는 300이하의 자연수
//10000이하의 자연수
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[301];
        int[] scores = new int[301];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }
        scores[1] = stairs[1];
        scores[2] = stairs[1] + stairs[2];
        scores[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++) {
            scores[i] = Math.max(scores[i-3] + stairs[i-1] , scores[i-2]) + stairs[i];
        }

        System.out.println(scores[N]);
    }
}
