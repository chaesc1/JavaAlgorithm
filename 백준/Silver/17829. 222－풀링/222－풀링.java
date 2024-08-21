import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(polling(N));
    }

    // 배열을 2 x 2로 잘라서 각 폴링에서 두번째로 큰 수로 합침
    private static int polling(int size) {
        if (size == 1) {
            return map[0][0];
        }
        int newSize = size / 2;
        int[][] newMap = new int[newSize][newSize];

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                int[] temp = {
                        map[i * 2][j * 2],
                        map[i * 2][j * 2 + 1],
                        map[i * 2 + 1][j * 2],
                        map[i * 2 + 1][j * 2 + 1]
                };

                Arrays.sort(temp);
                newMap[i][j] = temp[2];
            }
        }

        map = newMap;
        return polling(newSize);
    }
}