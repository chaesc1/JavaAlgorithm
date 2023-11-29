package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class P2 {
    // 도착 지점과, 도착지점으로 가는 비용을 의미하는 클래스를 정의한다.
    static class Node {
        String idx;
        int cost;

        // 생성자
        Node(String idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static String[][] way;
    static int fuel,n;


    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //마을 개수
        int[] towns = new int[n];
        for (int i = 1; i <= n; i++) {
            towns[i] = i;
        }
        int money = 100;
        fuel = Integer.parseInt(st.nextToken());//시작 연료량
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int t = Integer.parseInt(br.readLine()); // 마을간 경로 개수
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            //from 에서 to 까지 거리는 dist 이다.
            String from = st.nextToken();
            String to = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());

            // 그래프에 간선 추가 (양방향)
            graph.get(Integer.parseInt(from)).add(new Node(to, dist));
            graph.get(Integer.parseInt(to)).add(new Node(from, dist));
        }

        // 최소 비용 경로 탐색
        int result = findMinimumCostPath("출발지", "목적지");
        System.out.println(result);
    }
    static int findMinimumCostPath(String start, String end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        distance[Integer.parseInt(start)] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIdx = Integer.parseInt(current.idx);

            if (currentIdx == Integer.parseInt(end)) {
                return distance[currentIdx];
            }

            if (current.cost > distance[currentIdx]) {
                continue;
            }

            for (Node next : graph.get(currentIdx)) {
                int nextIdx = Integer.parseInt(next.idx);
                int cost = current.cost + next.cost;

                if (cost < distance[nextIdx]) {
                    distance[nextIdx] = cost;
                    pq.offer(new Node(next.idx, cost));
                }
            }
        }
        return -1;
    }
}
