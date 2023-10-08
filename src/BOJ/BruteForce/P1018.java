package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class P1018 {
    static int min = 64;
    static Boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new Boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'W'){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n-7; i++) {
            for (int j = 0; j < m-7; j++) {
                solution(i,j);
            }
        }
        System.out.println(min);
    }

    private static void solution(int x, int y) {
        int count = 0;
        boolean blackOrWhite = map[x][y];
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if(map[i][j] != blackOrWhite){
                    count++;
                }
                //올바르면 다음칸으로 가는데
                // 처음이 흰색이면 다음칸은 검은색
                // 처음이 검은색이면 다음칸은 흰색
                blackOrWhite = !blackOrWhite;
            }
            //다음줄도 바꿔줘야해
            blackOrWhite = !blackOrWhite;
        }
        count = Math.min(count,64-count);
        min = Math.min(min,count);
    }
}
