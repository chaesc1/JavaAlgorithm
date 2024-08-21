import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cntBlue = 0; // 파란 색종이 수
    static int cntWhite = 0; // 하얀 색종이 수
    static int arr[][];

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(cntWhite);
        System.out.println(cntBlue);

    }

    // 종이가 같은 색으로 칠해져 있지 않으면 4등분
    static void divide(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                cntBlue++;
            } else {
                cntWhite++;
            }
            return;
        }

        int newSize = size / 2;
        divide(row, col, newSize); // 2사분면
        divide(row, col + newSize, newSize); // 1사분면
        divide(row + newSize, col, newSize); // 3사분면
        divide(row + newSize, col + newSize, newSize); // 4사분면
    }

    // 종이의 색이 같은지 확인
    static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}