import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		int lenA = A.length;
		int lenB = B.length;
		
		dp = new int[lenA + 1][lenB +1];
		
		for(int i=1; i<=lenA; i++) {
			for(int j=1; j<=lenB; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		findString(A, lenA, lenB);
		System.out.println(dp[lenA][lenB]);
		System.out.println(sb);
	}
	
	private static void findString(char[] words, int lenA,int lenB) {
		Stack<Character> stack = new Stack<>();
		
		while(lenA > 0 && lenB > 0) {
			if (dp[lenA][lenB] == dp[lenA-1][lenB]) {
				lenA--;
			} else if(dp[lenA][lenB] == dp[lenA][lenB-1]) {
				lenB--;
			} else {
				stack.push(words[lenA-1]);
				lenA--;
				lenB--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
