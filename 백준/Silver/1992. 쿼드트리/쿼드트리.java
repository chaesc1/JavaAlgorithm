import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // 사분면으로 쪼개고 쪼개서 그 사분면이 전부 같은수면 해당 숫자로 압축한다.
        System.out.println(quadTree(0, 0, N));
    }

    private static String quadTree(int x, int y, int size) {
        // 첫 좌측 위 상단 좌표를 기준으로 잡아보고
        int flag = map[x][y];
        int cnt = 1;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != flag) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");

                    int reSize = size / 2;
                    sb.append(quadTree(x, y, reSize)); // 1사분면
                    sb.append(quadTree(x, y+reSize, reSize)); // 2사분면
                    sb.append(quadTree(x+reSize, y, reSize)); // 3사분면
                    sb.append(quadTree(x+reSize, y+reSize, reSize)); // 4사분면

                    sb.append(")");
                    return sb.toString();
                }
            }
        }
        return String.valueOf(flag);
    }
}