import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		int MAX_SIZE = 1000001;
		boolean[] card = new boolean[MAX_SIZE];
		int[] score = new int[MAX_SIZE];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			card[arr[i]] = true;
		}
		
		for(int num : arr) {
			for(int i= num*2; i<MAX_SIZE; i+=num) {
				if (card[i]) {
					++score[num];
					--score[i];
				}
			}
		}
		
	
		StringBuilder sb = new StringBuilder();
		for(int num : arr) {
			sb.append(score[num]).append(' ');
		}
		
		System.out.println(sb);
	}
}
