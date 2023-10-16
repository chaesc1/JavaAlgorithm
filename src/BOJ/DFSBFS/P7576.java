package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
//저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
// 토마토가 모두 익지는 못하는 상황이면 -1을 출력
public class P7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[] {i,j,0}); //이미 익어있는 토마토의 좌표를 큐에 삽입
                }
            }
        }

        int res = bfs();
        System.out.println(res);
    }

    private static int bfs() {
        int day = 0;
        while (!q.isEmpty()){
            int[] point = q.poll();
            int curX = point[0];
            int curY = point[1];
            day = point[2];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m ){
                    if(map[nx][ny] == 0 ){
                        map[nx][ny] = 1;
                        q.offer(new int[]{nx,ny,day+1});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    return -1;
                }
            }
        }
        return day;
    }
}
