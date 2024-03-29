import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//영역 구하기 - 실버1 DFS/BFS

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int M,N;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        int K = Integer.parseInt(st.nextToken()); 
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1; //
                }
            }
        }
        count = 0; //영역개수
        //영역 개수를 저장할 ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    count = 0;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        //list 정렬 오름 차순
        Collections.sort(list);
//        System.out.println("list = " + list);
        StringBuilder sb = new StringBuilder();

        sb.append(list.size());
        System.out.println(sb);
        for(int i : list){
            System.out.print(i+" ");
        }
    }
    private static void dfs(int i, int j) {
        map[i][j] = 1;
        count++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(0 <= nx && nx < N &&  0 <= ny && ny < M){
               if(map[nx][ny] == 0){
                   dfs(nx,ny);
               }
            }
        }
    }
}
