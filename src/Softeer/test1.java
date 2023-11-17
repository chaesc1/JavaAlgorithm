package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test1 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] area;
    static int answer = 0; // 섬 개수
    static ArrayList<Integer> count;
    static int lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
//        visited = new boolean[lines][lines];

        for(int i=0; i<lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<lines; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = new ArrayList<>(); // 카운트 담을 array
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (area[i][j] == 1) {
                    answer++;
                    count.add(dfs(i,j));
                }
            }
        }
        count.sort(Comparator.naturalOrder());
        System.out.println(answer);
        for(int i : count){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int dfs(int curX ,int curY) {
        area[curX][curY] = 0;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {

            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx >= 0 && nx < lines && ny >= 0 && ny <lines && area[nx][ny] == 1) {
                area[nx][ny] = 0; // 방문처리
                cnt+=dfs(nx,ny);
            }
        }
        return cnt;

    }
}
