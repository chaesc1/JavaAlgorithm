package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2819 {
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static HashSet<String> hash;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            hash = new HashSet<>();
            map = new int[4][4];
            StringTokenizer st;
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    dfs(j,k,0,String.valueOf(map[j][k]));
                }
            }

            System.out.println("#"+i+" "+hash.size());
        }
    }

    private static void dfs(int x, int y, int depth, String s) {
        if(depth==6) { //base case
            hash.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx,ny,depth+1,s+String.valueOf(map[nx][ny]));
            }
        }
    }
}
