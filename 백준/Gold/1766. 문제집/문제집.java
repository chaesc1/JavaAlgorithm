import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] inDegree = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 그래프 설정 
			graph.get(start).add(end);
			inDegree[end]++; 
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(inDegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			
			for(int next : graph.get(now)) {
				inDegree[next]--;
				
				if(inDegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		
		System.out.println(sb);
	}
}
