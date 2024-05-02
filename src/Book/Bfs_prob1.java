package Book;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Bfs_prob1 {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n+1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edges : graph) {
            adjList[edges[0]].add(edges[1]);

        }
        visited = new boolean[n+1];
        answer = new ArrayList<>();

        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    private static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            answer.add(now);

            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1,2},{1,3},{2,4},{2,5},{3,6},{5,6}
        };
        int[] solution = solution(graph, 1, 6);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
