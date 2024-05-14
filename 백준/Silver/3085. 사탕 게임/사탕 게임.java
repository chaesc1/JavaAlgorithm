import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int answer,N;

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 행기준
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                // 바꾸고
                swap(i, j, i, j + 1);
                // 탐색하고
                search();
                // 다시 돌리고
                swap(i, j + 1, i, j);
            }
        }
        // 열기준
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                // 바꾸고
                swap(i, j, i + 1, j);
                // 탐색하고
                search();
                // 다시 돌리고
                swap(i + 1, j, i, j);

            }
        }

        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static void search() {
        // 행 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N-1; j++) {
                if (map[i][j] == map[i][j+1]) {
                    count++;
                    max = Math.max(max,count);
                } else {
                    count = 1;
                }
            }
        }
        // 열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N-1; j++) {
                if (map[j][i] == map[j+1][i]) {
                    count++;
                    max = Math.max(max,count);
                } else {
                    count = 1;
                }
            }
        }
    }
}
