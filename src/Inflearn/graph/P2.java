package Inflearn.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class P2 {

    public boolean solution(int[][] friends) {
        int n = friends.length;
        int[] color = new int[n]; // 0: 미방문 , 1: 홍팀, 2: 청팀

        for(int i=0; i<n; i++) {
            // 방문한 노드면
            if (color[i] != 0) continue;

            color[i] = 1; // 홍팀 지정
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for(int next : friends[cur]) {
                    // 다음 노드가 미방문 노드면
                    if (color[next] == 0) {
                        // 현재 노드의 색이 홍 -> 다음 노드 청 , 청 -> 홍
                        if (color[cur] == 1) {
                            color[next] = 2;
                        } else {
                            color[next] = 1;
                        }
                        q.offer(next);
                    } else if (color[next] == color[cur]) {
                        // 친구끼리 같은 편이면
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P2 p2 = new P2();

        System.out.println(p2.solution(new int[][]{{1}, {2}, {0}}));       // false (홀수 사이클)
        System.out.println(p2.solution(new int[][]{{1, 2}, {0, 3}, {0}, {1}})); // true
    }
}
