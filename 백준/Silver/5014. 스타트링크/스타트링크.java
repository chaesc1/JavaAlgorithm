import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//스타트링크 - 실버 1
//첫째 줄에 F, S, G, U, D가 주어진다.
// (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고,
// 가장 높은 층은 F층이다.
public class Main {
    static int F, S, G, U, D,count;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        count = -1;
        int ans = BFS(F,S,G,U,D);
        if(ans >= 0) System.out.println(ans);
        else System.out.println("use the stairs");
    }

    private static int BFS(int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        visited[s] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(cur == g) return count;
                //현재위치 + up 이 최고층이거나 낮거나 방문하지 않았다면?
                if(cur+u <= f && !visited[cur+u]){
                    queue.offer(cur+u);
                    visited[cur+u] = true;
                }
                if(cur-d > 0 && !visited[cur-d]){
                    queue.offer(cur-d);
                    visited[cur-d] = true;
                }
            }

        }

        return -1;
    }
}
