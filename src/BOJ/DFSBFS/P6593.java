package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.StringTokenizer;

//상범빌딩
// 6개 정육면체 ??
//금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고,
// 비어있는 칸은 '.'으로 표현된다.
// 당신의 시작 지점은 'S'로 표현되고,
// 탈출할 수 있는 출구는 'E'로 표현
public class P6593 {
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static char[][][] map;
    static int L, R, C;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            count = -1;
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            //결과 출력
            if(L==0 && R==0 && C==0) break;
            map = new char[L][R][C];
            int x=0, y=0, z=0; // bfs 시작할 시작지점좌표 저장
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = input.charAt(k);
                        if(map[i][j][k] == 'S'){
                            //시작점 S 면 해당 지점도 비어 있는 칸으로 설정
                            x = k;
                            y = j;
                            z = i;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();//빈 공백한줄
            }
            int res = bfs(x,y,z);
            if(res == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + res+ " minute(s).");
        }
    }

    private static int bfs(int x, int y, int z) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y,z});
        boolean[][][] visited = new boolean[L][R][C];
        visited[z][y][x] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int test = 0; test < size; test++) {
                int[] q = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int curX = q[0], curY = q[1], curZ = q[2];
                    if(map[curZ][curY][curX] == 'E'){
                        return count;
                    }
                    int nx = curX+dx[i];
                    int ny = curY+dy[i];
                    int nz = curZ+dz[i];
                    if(0<=nx && nx < C && 0<=ny && ny < R && 0 <= nz && nz < L){
                        if(!visited[nz][ny][nx]){
                            if(map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E'){
                                visited[nz][ny][nx] = true; //방문표시하고
                                queue.offer(new int[] {nx,ny,nz}); //큐에 삽입
                            }
                        }
                    }
                }
            }

        }
        return -1;
    }
}
