import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            // 우선순위 큐
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(); //MinQueue
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //MaxQueue
            HashMap<Integer, Integer> map = new HashMap<>();

            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    pq1.add(num);
                    pq2.add(num);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    PriorityQueue<Integer> queue = num == 1 ? pq2 : pq1;
                    removeMap(queue, map);
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int n = removeMap(pq2,map);
                System.out.println(n + " " + (!map.isEmpty() ? removeMap(pq1, map) : n));
            }
        }
    }
    private static int removeMap(PriorityQueue<Integer> queue, HashMap<Integer,Integer> map) {
        int num;
        while (true) {
            num = queue.poll();
            int cnt = map.getOrDefault(num,0);

            if (cnt == 0) {
                continue;
            }
            if (cnt == 1) {
                map.remove(num);
            } else {
                map.put(num, cnt - 1);
            }
            break;
        }
        return num;
    }
}
