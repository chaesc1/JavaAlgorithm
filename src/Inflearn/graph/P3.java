package Inflearn.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class P3 {
    public int solution(int[] coins, int amount) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{amount, 0});
        visited.add(amount);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curAmount = cur[0];
            int count = cur[1];
            if (curAmount == 0) {
                return count;
            }

            for(int coin : coins) {
                int nextAmount = curAmount - coin;
                if (nextAmount < 0) continue;
                if (!visited.contains(nextAmount)) {
                    queue.add(new int[] {nextAmount, count + 1});
                    visited.add(nextAmount);
                }
            }
        }
        /*queue.offer(0);
        visited[0] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for(int coin : coins) {
                    int next = cur + coin;

                    if (next == amount) return count;

                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

        }*/
        return -1;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();

        System.out.println(p3.solution(new int[]{10, 5, 25, 1}, 30)); // 2
        System.out.println(p3.solution(new int[]{9, 4, 1}, 12));      // 3
        System.out.println(p3.solution(new int[]{3, 7}, 5));          // -1
        System.out.println(p3.solution(new int[]{1, 5, 7}, 0));       // 0
    }
}
