import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, count;
    static int rain;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //입력과 동시에 최고 높이인 집 찾아
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max_height < map[i][j]){
                    max_height = map[i][j];
                }
            }
        }
        rain = 1;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= max_height; i++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && map[j][k] > i){
                        cnt += dfs(j,k,i);
                    }
                }
            }
            max = Math.max(max,cnt);
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y,int rain) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(!visited[nx][ny] && map[nx][ny] > rain){
                    visited[nx][ny] = true;
                    dfs(nx,ny,rain);
                }
            }
        }

        return 1;
    }
}
