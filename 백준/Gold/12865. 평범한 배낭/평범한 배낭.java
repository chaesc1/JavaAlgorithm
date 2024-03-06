import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] W;
    static int[] V;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        //수용가능한 무게로 dp 테이블 작성
        dp = new int[N][K+1];

        W = new int[N]; //무게
        V = new int[N]; //가치
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //물건의 무게, 물건의 가치가 주어짐
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N-1,K));
    }

    private static int solution(int i, int k) {
        if (i < 0) return 0;

        //탐색안된 위치면
        if (dp[i][k] == 0) {
            //물건을 더이상 못 담는 경우면?
            if (W[i] > k) {
                dp[i][k] = solution(i-1,k); // 이전값 가져와서 넣어
            }
            else {
                // 담을 수 있는 경우
                //이전 i값, 이전 i값에 대한 k-W[i] + V[i]
                dp[i][k] = Math.max(solution(i-1,k),solution(i-1,k-W[i])+V[i]);
            }
        }
        return dp[i][k];
    }

}
