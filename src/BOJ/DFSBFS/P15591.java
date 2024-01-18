package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//각 동영상을 정점으로 나타내
//K를 정해서 K 이상인 모든 동영상이 추천되도록

public class P15591 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<int []>();
        }
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adj[p].add(new int[] {q,r});
            adj[q].add(new int[] {p,r});
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int answer = 0;

            int[] visited = new int[N+1];
            Queue<Integer> queue = new LinkedList<>();
            visited[v] = 1;
            queue.add(v);

            while (!queue.isEmpty()){
                int now = queue.poll();
                for (int[] arr : adj[now]) {
                    int next = arr[0];
                    int usado = arr[1];
                    if (visited[next] == 1 || usado < k) continue;

                    answer++;
                    visited[next] = 1;
                    queue.add(next);
                }
            }
            System.out.println(answer);
        }
    }
}
