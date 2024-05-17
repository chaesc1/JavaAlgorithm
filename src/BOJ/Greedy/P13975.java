package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13975 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            Long sum = 0L;
            while (pq.size()>1) {
                Long a = pq.poll();
                Long b = pq.poll();

                sum += (a+b);
                pq.add(a+b);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
