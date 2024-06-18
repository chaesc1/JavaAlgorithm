package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1911 {
    static class Hole implements Comparable<Hole> {
        int start;
        int end;

        public Hole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Hole o) {
            if (this.start == o.start) {
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Hole> pq = new PriorityQueue<>();
        // 웅덩이 정보 시작 - 끝
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Hole(s, e));
        }

        int fill = 0; // 덮힌 마지막 값
        int answer = 0;
        while(!pq.isEmpty()) {
            Hole cur = pq.poll(); // 현재 정보
            if (cur.end < fill) continue;

            if (cur.start > fill) fill = cur.start;

            int remain = (cur.end - fill) % L;
            answer += (cur.end - fill) / L;
            fill = cur.end;

            if (remain != 0) {
                answer++;
                fill += (L - remain);
            }
        }

        System.out.println(answer);
    }
}
