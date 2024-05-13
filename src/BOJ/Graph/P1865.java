package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int end;
    int cost;

    public Edge(int end,int cost) {
        this.end = end;
        this.cost = cost;
    }
}

/*
* 테스트 케이스 tc
*
*웜홀은 시작 위치에서 도착 위치로 가는 하나의 경로인데,
* 특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게 된다.
* 웜홀 내에서는 시계가 거꾸로 간다고 생각하여도 좋다.
* */
public class P1865 {
    static int N;
    static int M;
    static int W;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            graph = new ArrayList<>(); //init graph

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < M+W; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                //Worm Hole X -> 양방향 그래프
                if (i < M) {
                    graph.get(start).add(new Edge(end,weight));
                    graph.get(end).add(new Edge(start,weight));
                } else {
                    // Worm Hole -> 단방향 -> 가중치는 음수 -> 벨만포드?
                    graph.get(start).add(new Edge(end,-weight));
                }
            }

            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }
    }

    private static boolean bellmanFord() {
        Arrays.fill(dist,INF);
        dist[1] = 0; // 시작점-> 0
        boolean flag = false;

        for (int i = 1; i < N; i++) {
            flag = false;

            for (int j = 1; j <= N; j++) {
                for (Edge edge : graph.get(i)) {
                    if (dist[edge.end] > dist[j] + edge.cost) {
                        dist[edge.end] = dist[j] + edge.cost;
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            return true;
        }
        return false;
    }
}
