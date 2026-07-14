package Inflearn.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1 {

    public int solution(int[][] lockers) {
        boolean[] visited = new boolean[lockers.length];
        dfs(0, lockers, visited);
        // bfs code

        int answer = 0;

        /*Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : lockers[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }*/
        for(boolean visit : visited) {
            // 방문 X -> 열 수 없는 라커
            if (!visit) answer++;
        }
        return answer;
    }

    private void dfs(int lockerNum, int[][] lockers, boolean[] visited) {
        if (visited[lockerNum]) return;
        visited[lockerNum] = true;

        for(int key : lockers[lockerNum]) {
            dfs(key, lockers,visited);
        }
    }

    public static void main(String[] args) {
        P1 p1 = new P1();
        System.out.println(p1.solution(new int[][]{{1, 2}, {3}, {}, {0}})); // 0
        System.out.println(p1.solution(new int[][]{{1, 3}, {2, 4}, {0}, {4}, {}, {3, 4}})); // 1
        System.out.println(p1.solution(new int[][]{{0, 1}, {0, 1}, {2, 3}, {2, 3}})); // 2
    }
}
