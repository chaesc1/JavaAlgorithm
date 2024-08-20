import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Room implements Comparable<Room>{
        int num;
        int start;
        int end;

        public Room(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (o.start == this.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Room> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Room(num, start, end));
        }

        Collections.sort(list);

        int result = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            pq.offer(list.get(i).end);
            result = Math.max(result, pq.size());
        }

        System.out.println(result);
    }
}