import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point company;
    static Point home;
    static Point[] customers;
    static boolean[] visited;
    static int minDistance;
    static int N;

    //회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려 한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            N = Integer.parseInt(br.readLine());

            //테스트 케이스의 첫째 줄에는 고객의 수 N이 주어진다. 둘째 줄에는 회사의 좌표,집의 좌표, N명의 고객의 좌표가 차례로 나열된다.
            st = new StringTokenizer(br.readLine());
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customers = new Point[N];
            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            findShortestPath(0, 0, company);
            System.out.println("#" + tc + " " + minDistance);
        }
    }
    //회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성
    private static void findShortestPath(int cnt, int distance, Point company) {
        if (cnt == N) {
            minDistance = Math.min(minDistance, distance + getDistance(home, company));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] =true;
            findShortestPath(cnt+1,distance + getDistance(company,customers[i]),customers[i]);
            visited[i] = false;
        }
    }

    private static int getDistance(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}