package BOJ.DivisionalConquest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int row, int col, int size) {
        if (sameColor(row, col, size)) {
            if (map[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        //2사분면
        partition(row, col, newSize);
        //1사분면
        partition(row, col + newSize, newSize);
        //3사분면
        partition(row + newSize, col, newSize);
        //4사분면
        partition(row + newSize, col + newSize, newSize);
    }

    private static boolean sameColor(int row, int col, int size) {
        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
