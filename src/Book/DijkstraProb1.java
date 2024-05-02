package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraProb1 {
    static class Node {
        int dest,cost;

        public Node(int dest,int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static int[] solution(int[][] graph,int start,int n) {
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edges : graph) {
            adjList[edges[0]].add(new Node(edges[1],edges[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        //시작지점을 0을 초기화
        dist[start] = 0;

        //cost 순으로 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost ,o2.cost));
        pq.add(new Node(start,0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }
        return dist;
    }
}
