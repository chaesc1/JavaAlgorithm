package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P24480 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //정점 저장 그래프
    static int[] check; //방문 체크 배열
    static int count; // 방문 순서.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        check = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            //무방향 그래프
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //오름차순 정렬
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        count = 1;//시작 정점도 포함
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int start) {
        check[start] = count;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int newStart = graph.get(start).get(i);
            if (check[newStart] == 0) {
                count++;
                dfs(newStart);
            }
        }
    }
}
