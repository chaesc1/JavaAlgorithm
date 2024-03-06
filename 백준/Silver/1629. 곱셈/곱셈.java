import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
public class Main{
    static long C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(solution(A, B));
    }

    private static long solution(long num, long exp) {
        if (exp == 1) {
            return num % C;
        }

        long sum = solution(num, exp / 2);
        //지수승이 홀수 인 경우
        //A^11 -> A^5 * A^5 * A^1
        if (exp % 2 == 1) {
            return (sum * sum % C) * num % C;
        }

        return (sum * sum % C);
    }
}
