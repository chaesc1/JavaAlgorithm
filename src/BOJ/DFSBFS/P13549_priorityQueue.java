package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//숨바꼭질3 - gold3
// 순간이동 (*2 ) -> 0 초
// 1 앞으로 -> 1초 , 1 뒤로 -> 1초

public class P13549_priorityQueue {
    //가장 빠른 시간을 구해야해.
    static int[] dx = {-1, 1};
    static class Node implements Comparable<Node>{
        int x;
        int time;
        public Node(int x, int time) {
            this.x =x;
            this.time =time;
        }
        @Override
        public int compareTo(Node o) {
            return this.time- o.time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bfs(N, K);
    }

    public static void bfs(int N, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(N,0));
        boolean[] isVisit = new boolean[100001];
        isVisit[N] = true;

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int pos = p.x;
            int time = p.time;
            isVisit[pos] = true;

            if (pos == K) {
                System.out.println(time);
                return;
            }

            int jump = pos * 2;
            if(jump < 100001 && !isVisit[jump]) {
                pq.add(new Node(jump,time));
            }

            for (int i = 0; i < 2; i++) {
                int nx = pos + dx[i];
                if (nx >= 0 && nx < 100001 && !isVisit[nx]) {
                    pq.add(new Node(nx,time+1));
                }
            }
        }
    }
}
