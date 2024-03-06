import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            answer += sum;
            pq.offer(sum);
        }
        System.out.println(answer);
    }
}
