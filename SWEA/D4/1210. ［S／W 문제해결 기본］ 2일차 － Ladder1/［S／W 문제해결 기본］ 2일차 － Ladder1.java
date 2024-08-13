import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int destX = 0;
    static int destY = 0;
    static int answer = 0;
    static int[][] map = new int[100][100];
    static int[] dx = {-1,1,0};
    static int[] dy = {0,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) { // 도착지점이면?
                        destX = j;
                        destY = i;
                    }
                }
            }

            solve(destX,destY); //역으로 올라가자!

            System.out.println("#"+tc+" "+answer);
        }
    }
    public static void solve(int destX,int destY) {
        while (true) {
            if (destY == 0) {
                answer = destX;
                return;
            }
            for (int i = 0; i < 3; i++) {
                int nx = destX + dx[i];
                int ny = destY + dy[i];

                if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                    if (map[ny][nx] == 1) {
                        map[ny][nx] = 3; //방문표시
                        destX = nx;
                        destY = ny;
                    }
                }
            }
        }
    }
}
