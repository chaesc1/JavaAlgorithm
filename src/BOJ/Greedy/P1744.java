package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //음수는 오름차순으로 우선순위 큐 생성
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        //양수는 내림차순으로 우선순위 큐
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        int result = getSum(minus) + getSum(plus);
        System.out.println(result);
    }

    private static int getSum(PriorityQueue<Integer> pq) {
        Queue<Integer> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (pq.isEmpty()) {
                queue.add(cur);
            } else {
                int next = pq.poll();
                if (cur == 1 || next == 1) {
                    // 1은 곱하면 손해
                    queue.add(cur);
                    queue.add(next);
                } else {
                    queue.add(cur * next);
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }
}
