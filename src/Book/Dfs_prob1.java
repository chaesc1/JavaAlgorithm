package Book;

import java.util.ArrayList;

public class Dfs_prob1 {
    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph,int start, int n) {
        adjList = new ArrayList[n+1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        //그래프를 인접리스트로 변환
        for (int[] edges : graph) {
            adjList[edges[0]].add(edges[1]);
        }

        visited = new boolean[n+1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);

        for (int next : adjList[now]) {
            if (!visited[next]) {
                System.out.println(next);
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1,2},{1,3},{2,4},{2,5},{3,6},{5,6}
        };
        int[] solution = solution(graph, 1, 6);
        System.out.println(solution.toString());
    }
}
