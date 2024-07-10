import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 질문 개수
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(isPalin(arr,start,end)) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}
        System.out.println(sb);
	}
	
	private static boolean isPalin(int[] arr, int start, int end) {
		while(start <= end) {
			if (arr[start] != arr[end]) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
}
