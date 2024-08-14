import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/***
 *
 */
 
public class Solution {
    static int cnt;
    static int T, N, M, maxTotal;
    static int[][] graph;
    static boolean[][] visited;
    // 이차원 배열로 탐색한다 + cnt로 시작점 (x, y)를 넘겨줘야 한다. -> 최대값 계속 갱신해주기!
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maxTotal = 0;
            graph = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            check(0, 0);
            sb.append("#").append(tc).append(" ").append(maxTotal).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void check(int x, int y) {
        int total = 0;
        if (visited[x][y]) return;
        visited[x][y] = true;
        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++) {

                if (i >= N || j >= N)
                    return;
                total += graph[i][j];
            }
        }
        if (maxTotal < total)
            maxTotal = total;
        check(x + 1, y);
        check(x, y + 1);
 
    }
}