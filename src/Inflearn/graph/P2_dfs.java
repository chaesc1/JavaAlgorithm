package Inflearn.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class P2_dfs {

    public boolean solution(int[][] friends) {
        int n = friends.length;
        int[] color = new int[n]; // 0: 미방문 , 1: 홍팀, 2: 청팀

        for(int i=0; i<n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                if (!dfs(i,friends,color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int[][] friends, int[] color) {
        for(int next : friends[cur]) {
            if (color[next] == 0) {
                if (color[cur] == 1) {
                    color[next] = 2;
                } else {
                    color[next] = 1;
                }
                if (!dfs(next, friends, color)) return false;
            } else if (color[next] == color[cur]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        P2_dfs p2 = new P2_dfs();

        System.out.println(p2.solution(new int[][]{{1}, {2}, {0}}));       // false (홀수 사이클)
        System.out.println(p2.solution(new int[][]{{1, 2}, {0, 3}, {0}, {1}})); // true
    }
}
