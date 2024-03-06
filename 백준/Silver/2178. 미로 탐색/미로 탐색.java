
//미로 탐색 - 실버1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        //미로 입력 받기
        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = num.charAt(j) - '0';
//                System.out.println("map[i] = " + map[i][j]);
            }
        }

        //첫 시작점은 방문표시
        visited[0][0] = true;
        bfs(0,0); // 좌표로 bfs
        System.out.println(map[n - 1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                //Out of map
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                } else if(visited[nextX][nextY] || map[nextX][nextY] == 0){
                    //visited Or Wall (0)
                    continue;
                }
                queue.add(new int[] {nextX,nextY});
                map[nextX][nextY] = map[curX][curY] + 1; //이전 좌표에서 1씩 더해가
                visited[nextX][nextY] = true;//방문표시
            }
        }
    }
}
