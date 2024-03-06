import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static boolean[][] isVisited = new boolean[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행 , 열, 격자 탐색
        solve(0, 0);
    }

    private static void solve(int row, int col) {
        //해당 행이 채워진 경우 다음 열로 이동
        if (col == 9) {
            solve(row + 1, 0); // 다음줄로
            return;
        }
        //행, 열 모두 채워진 경우
        if (row == 9) {
            //출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);

        }
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                //i와 중복된건지 판단
                if (isSudoku(row, col, i)) {
                    map[row][col] = i;
                    solve(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }
        solve(row, col + 1);
    }

    public static boolean isSudoku(int row, int col, int num) {
        //행
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return false;
            }
        }

        //열
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) {
                return false;
            }
        }

        //격자
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;

        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol+3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
