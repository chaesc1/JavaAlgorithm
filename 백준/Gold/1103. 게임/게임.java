import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//게임
//형택이는 1부터 9까지의 숫자와, 구멍이 있는 직사각형 보드에서 재밌는 게임을 한다.
//
//일단 보드의 가장 왼쪽 위에 동전을 하나 올려놓는다. 그다음에 다음과 같이 동전을 움직인다.
//
//동전이 있는 곳에 쓰여 있는 숫자 X를 본다.
//위, 아래, 왼쪽, 오른쪽 방향 중에 한가지를 고른다.
//동전을 위에서 고른 방향으로 X만큼 움직인다. 이때, 중간에 있는 구멍은 무시한다.
//만약 동전이 구멍에 빠지거나, 보드의 바깥으로 나간다면 게임은 종료된다. 형택이는 이 재밌는 게임을 되도록이면 오래 하고 싶다.
//
//보드의 상태가 주어졌을 때, 형택이가 최대 몇 번 동전을 움직일 수 있는지 구하는 프로그램을 작성하시오.
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map,dp;
    static boolean[][] visited;
    static int N,M,max;
    static boolean isCycle;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M]; //백트래킹
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            for (int j = 0; j < M; j++) {
                //H 를 10으로 처리
                if(num.charAt(j) == 'H'){
                    map[i][j] = 10;
                }else{
                    map[i][j] = Integer.parseInt(String.valueOf(num.charAt(j)));
                }
            }
        }
        visited[0][0] = true;
        isCycle = false; // loop 플래그
        //dfs -> max 값을 구해야해..
        dfs(0,0,1);
        if(isCycle) System.out.println(-1);
        else System.out.println(max);
    }
    private static void dfs(int x,int y,int count){
        if(max < count){
            max = count;
        }
        dp[y][x] = count;
        for (int i = 0; i < 4; i++) {
            int num = map[y][x];
            //보드 숫자만큼 방향이동
            int nx = x + dx[i]*num;
            int ny = y + dy[i]*num;

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 10) continue;
            if(visited[ny][nx]){
                isCycle = true;
                return;
            }
            if(dp[ny][nx] > count) continue;
            visited[ny][nx] = true;
            dfs(nx,ny,count+1);
            visited[ny][nx] = false;
        }
    }
}
