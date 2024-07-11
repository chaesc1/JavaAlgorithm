import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end, cost));
			graph[end].add(new Node(start,cost));
		}
		
		//prim algorithm
		System.out.println(prim());
	}
	
	private static int prim() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(1,0));
		
		int max = 0;
		int dist = 0; // sum Of cost
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(visited[cur.end]) continue;
			
			visited[cur.end] = true;
			dist += cur.cost;
			max = Math.max(max,cur.cost);
			
			for(Node node : graph[cur.end]) {
				if (!visited[node.end]) {
					q.offer(node);
				}
			}
		}
		// 최소 신장 트리 구한다음 최대 가중치를 빼주면 된다
		return dist - max;
	}
}
