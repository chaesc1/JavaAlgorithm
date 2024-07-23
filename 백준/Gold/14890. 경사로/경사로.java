import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            // 행
            if (rowCal(i)) count++;
            if (colCal(i)) count++;
        }
        System.out.println(count);
    }

    private static boolean colCal(int col) {
        boolean[] isInclined = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];
            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                // 다음 계단이 한 칸 더 높으면
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isInclined[i - j]) return false;
                    if (board[i][col] != board[i - j][col]) return false;
                    isInclined[i - j] = true;
                }
            } else if (diff == 1) {
                // 다은 계단이 한 칸 더 낮으면
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isInclined[i + j]) return false;
                    if (board[i][col] - 1 != board[i + j][col]) return false;
                    isInclined[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean rowCal(int row) {
        boolean[] isInclined = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = board[row][i] - board[row][i + 1];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isInclined[i - j]) return false;
                    if (board[row][i] != board[row][i - j]) return false;
                    isInclined[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isInclined[i + j]) return false;
                    if (board[row][i] - 1 != board[row][i + j]) return false;
                    isInclined[i + j] = true;
                }
            }
        }
        return true;
    }
}
