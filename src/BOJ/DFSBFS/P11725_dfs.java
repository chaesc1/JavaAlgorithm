package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725_dfs {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //그래프 초기화
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        boolean[] visited = new boolean[N];
        int[] parent = new int[N];

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int node : graph.get(num)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parent[node] = num;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i]+1);
        }
    }
}
