import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// .	평지(전차가 들어갈 수 있다.)
// *	벽돌로 만들어진 벽
// #	강철로 만들어진 벽
// -	물(전차는 들어갈 수 없다.)
// ^    위쪽을 바라보는 전차(아래는 평지이다.)
// v	아래쪽을 바라보는 전차(아래는 평지이다.)
// <	왼쪽을 바라보는 전차(아래는 평지이다.)
// >	오른쪽을 바라보는 전차(아래는 평지이다.)

/*
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 */

public class Solution {
    static int H, W;
    static int tankX, tankY;
    static char[][] map;
    static String[] command;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] directions = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        tankX = i;
                        tankY = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            command = new String[N];
            String line = br.readLine();
            for (int i = 0; i < N; i++) {
                command[i] = line.charAt(i) + "";
            }

            battleField(command);
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void battleField(String[] command) {
        for (String cmd : command) {
            switch (cmd) {
                case "U":
                    moveTank(0);
                    break;
                case "D":
                    moveTank(1);
                    break;
                case "L":
                    moveTank(2);
                    break;
                case "R":
                    moveTank(3);
                    break;
                case "S":
                    shoot();
                    break;
            }
        }
    }

    //전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
    //탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
    // 강철벽은 포탄만 소멸될 뿐 그대로 존재
    private static void shoot() {
        int direction = -1;
        // 현재 바라보고 있는 방향 찾고
        for (int i = 0; i < 4; i++) {
            if (map[tankX][tankY] == directions[i]) {
                direction = i;
                break;
            }
        }
        int x = tankX;
        int y = tankY;
        while (true) {
            x += dx[direction];
            y += dy[direction];

            if (!isInBounds(x, y)) break;
            if (map[x][y] == '#') break;
            if (map[x][y] == '*') {
                map[x][y] = '.';
                break;
            }
        }
    }

    private static void moveTank(int d) {
        map[tankX][tankY] = directions[d];
        int nx = tankX + dx[d];
        int ny = tankY + dy[d];
        if (isInBounds(nx, ny) && map[nx][ny] == '.') {
            map[tankX][tankY] = '.';
            tankX = nx;
            tankY = ny;
            map[tankX][tankY] = directions[d];
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}