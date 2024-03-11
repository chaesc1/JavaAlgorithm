import java.util.*;

class Solution {
    //최저 예상 택시요금
    //다익스트라
    /*
        클래스 end , cost
        
    */
    static class Node implements Comparable<Node> {
        int end;
        int cost;
        
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    
    static ArrayList<Node>[] graph;
    static int MAX = 2000001;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] num : fares) {
            int c = num[0];
            int d = num[1];
            int f = num[2];
            //그래프 양방향연결
            graph[c].add(new Node(d,f));
            graph[d].add(new Node(c,f));
        }
        
        int[] arrA = dijkstra(a,n);//A
        int[] arrB = dijkstra(b,n); //B
        int[] arr = dijkstra(s,n); //합승
        
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer,arr[i] + arrA[i] + arrB[i]);
        }
        return answer;
    }
    
    private static int[] dijkstra(int start,int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,MAX);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0; //시작지점 비용은 0
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            //다음 노드들
            for(Node node : graph[now.end]) {
                if(dist[node.end] > node.cost + now.cost) {
                    dist[node.end] = node.cost + now.cost; 
                    pq.add(new Node(node.end , node.cost + now.cost));
                }
            }
        }
        return dist;
    }
}