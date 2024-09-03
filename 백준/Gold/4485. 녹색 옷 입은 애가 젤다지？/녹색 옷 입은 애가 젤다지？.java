import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visitied;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        count = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];
            visitied = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }
            dijkstra(0, 0);
        }

    }

    private static void dijkstra(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, map[x][y]));
        dist[x][y] = map[x][y];
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowCost = now.cost;
            if (nowX == N - 1 && nowY == N - 1) {
                System.out.println("Problem " + ++count + ": " + nowCost);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (!visitied[nx][ny]) {
                    visitied[nx][ny] = true;
                    int newCost = nowCost + map[nx][ny];
                    pq.offer(new Node(nx, ny, newCost));
                    dist[nx][ny] = newCost;
                }
            }
        }
    }
}