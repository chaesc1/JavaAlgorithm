import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] app = new int[n];
		int[] cost = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			app[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			total += cost[i];
		}
		//dp[i][j] -> i : 몇번째 앱까지인지 , j : 확보가능한 메모리의 크기
		int[][] dp = new int[n][10001];
		
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int c = cost[i];
			int mem = app[i];
			
			for(int j=0; j<10001; j++) {
				// 앱이 하나라면?
				if (i == 0) {
					if (j >= c) dp[i][j] = mem;
				} else {
					if (j >= c) {
						dp[i][j] = Math.max(dp[i-1][j-c] + mem , dp[i-1][j]);
					} else {
						dp[i][j] = dp[i-1][j]; // 크지 않다면 이전값 그대로 가져가
					}
				}
				
				if (dp[i][j] >= m) answer = Math.min(answer,j);
			}
		}
		
		System.out.println(answer);
	}
}
