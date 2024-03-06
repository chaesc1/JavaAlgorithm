import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end,cost));// 리스트 생성
            }
        }
        visited = new boolean[n+1];
        dfs(1,0); // 가장 멀리 떨어진 노드를 찾아서 저장하고

        visited = new boolean[n+1];
        dfs(node,0);

        System.out.println(max);
    }

    private static void dfs(int x,int dist) {
        if (dist > max) {
            max = dist;
            node = x;
        }
        visited[x] = true;
        for (int i = 0; i < list[x].size(); i++) {
            Node node = list[x].get(i);
            if (!visited[node.end]) {
                dfs(node.end, node.cost + dist);
                visited[node.end] = true;
            }
        }
    }
}
