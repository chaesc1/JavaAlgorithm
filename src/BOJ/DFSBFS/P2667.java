package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P2667 {
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = num.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    count=0;
//                    dfs(i,j);
                    bfs(i,j);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int num : list){
            System.out.println(num);
        }
    }

    private static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<N && 0<=ny && ny<N){
                if (!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }
            }
        }
    }
    private static void bfs(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        count++;
        visited[x][y] = true;
        while (!queue.isEmpty()){
            int curX = queue.peek()[0];
            int cutY = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = cutY + dy[i];

                if(0<=nx && nx < N && 0 <= ny && ny < N){
                    //방문하지 않고 영역이면?
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        //방문표시
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx,ny});
                        count++;
                    }
                }
            }
        }
    }
}
