//불
//불은 동서남북으로 이동
//
//첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.
//
//각 테스트 케이스의 첫째 줄에는 빌딩 지도의 너비와 높이 w와 h가 주어진다. (1 ≤ w,h ≤ 1000)
//
//다음 h개 줄에는 w개의 문자, 빌딩의 지도가 주어진다.
//
//'.': 빈 공간
//'#': 벽
//'@': 상근이의 시작 위치
//'*': 불
//각 지도에 @의 개수는 하나이다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int h,w;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> fire;
    static Queue<int[]> man;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());//가로
            w = Integer.parseInt(st.nextToken());//세로

            int sx=0, sy=0;
            map = new char[w][h];
            man = new LinkedList<>();
            visited = new boolean[w][h];
            fire = new LinkedList<>();

            for (int j = 0; j < w; j++) {
                String line = br.readLine();
                for (int k = 0; k < h; k++) {
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '@'){
                        //상근이의 시작 위치 저문
                        sx = k;
                        sy = j;
                        man.offer(new int[] {sx,sy});
                    }
                    else if(map[j][k] == '*'){
                        //불 위치를 큐에 넣어서 관리
                        fire.offer(new int[] {k,j});
                    }
                }
            }
            //bfs 수행
            int ans = escape();
            if(ans == 0) System.out.println("IMPOSSIBLE");
            else System.out.println(ans);
        }

    }

    private static int escape() {
        int count = 0;
        
        while (!man.isEmpty()){
            count++;
            int firesize = fire.size();
            for (int i = 0; i < firesize; i++) {
                int[] firePos = fire.poll();
                int curX = firePos[0];
                int curY = firePos[1];
                for (int j = 0; j < 4; j++) {
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = '*'; // 불이 이동
                            fire.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
            int mansize = man.size();
            for (int i = 0; i < mansize; i++) {
                int[] masPos = man.poll();
                int curX = masPos[0];
                int curY = masPos[1];
                for (int j = 0; j < 4; j++) {
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];

                    //맵 밖으로 나오면 count에 +1
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w){
                        return count;
                    }
                    if(map[ny][nx] == '.' && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        man.offer(new int[] {nx,ny});
                    }
                }
            }
        }
        return 0;
    }
}
