import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int idx, dist;
        public Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }

    private static ArrayList<Node>[] adjList;
    private static boolean[] visited;
    private static Node maxNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n==1) {
        System.out.println(0);
        return;
        }
        maxNode = new Node(0,0);
        visited = new boolean[n+1];
        adjList = new ArrayList[n+1]; 
        for(int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
    
        StringTokenizer st;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        // DFS 과정 첫 시작
        dfs(1);

        visited = new boolean[n+1];

        // 최장 거리 노드에서 다시 DFS 시작
        dfs(maxNode.idx);

        System.out.println(maxNode.dist);
    }

private static void dfs(int start) {
    Stack<Node> stack = new Stack<>();
    stack.push(new Node(start, 0));
    visited[start] = true;

    while (!stack.isEmpty()) {
        Node node = stack.pop();
        int currentNode = node.idx;
        int currentDist = node.dist;

        for (Node adjNode : adjList[currentNode]) {
            int nextNode = adjNode.idx;

            if (!visited[nextNode]) {
                visited[nextNode] = true;
                stack.push(new Node(nextNode, currentDist + adjNode.dist));

                if (maxNode.dist < currentDist + adjNode.dist) {
                    maxNode = new Node(nextNode, currentDist + adjNode.dist);
                }
            }
        }
    }
}
}