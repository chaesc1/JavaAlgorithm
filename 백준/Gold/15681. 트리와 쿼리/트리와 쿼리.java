import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,R,Q;
	static int[] qArr;
	static int[] count;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		// 그래프 생성
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
			graph[end].add(start);
		}

		// 주어진  U 를 기반으로 DFS
		count = new int[N+1];
		qArr = new int[Q];
		
		for(int i=0; i<Q; i++) {
			qArr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(R,-1);
		
		for(int root : qArr) {
			System.out.println(count[root]);
		}
	}
	private static void dfs(int root, int prev) {
		count[root] = 1;
		
		for(int subRoot : graph[root]) {
			if(subRoot == prev) continue;
			dfs(subRoot, root);
			count[root] += count[subRoot];
		}
	}
	
}
