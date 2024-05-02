import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//가장 길게 늘어나는 경우 - > 최장거리를 구해야해 , DFS + 다익스트라
public class Main {
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static ArrayList<Node>[] adjList;
    private static int answer;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(dest, cost));
            adjList[dest].add(new Node(start, cost));
        }

        answer = Integer.MIN_VALUE;
        visited = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            Arrays.fill(visited,false);
            dfs(i,0);
        }
        System.out.println(answer);
    }
    private static void dfs(int now, int cost) {
        visited[now] = true;
        answer = Math.max(answer,cost);

        for (Node next : adjList[now]) {
            int next_dest = next.dest;
            int next_cost = next.cost;

            if (!visited[next_dest]) {
                dfs(next_dest, cost + next_cost);
            }
        }

    }
}
