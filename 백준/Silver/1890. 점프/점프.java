import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int next = map[i][j];
				if (i == N-1 && j == N-1) continue;
				// 다음 경로가 맵 내부야한다.
				if(i + next < N) {
					dp[i+next][j] += dp[i][j];
				}
				
				if(j + next < N) {
					dp[i][j+next] += dp[i][j];
				}	
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}
