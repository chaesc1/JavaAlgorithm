import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String com = st.nextToken();

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            startGame(com);

            sb.append("#").append(t).append("\n");
            printMap();
        }
        System.out.println(sb.toString());
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void startGame(String command) {
        switch (command) {
            case "up":
                for (int i = 0; i < N; i++) {
                    int num = 0;
                    int index = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] != 0) {
                            // 같은 수가 있다면
                            if (num == map[j][i]) {
                                map[index - 1][i] = num * 2;
                                num = 0;
                                map[j][i] = 0;
                            } else {
                                num = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = num;
                                index++;
                            }
                        }
                    }
                }
                break;
            case "down":
                for (int i = 0; i < N; i++) {
                    int num = 0;
                    int index = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            // 같은 수 있다면
                            if (num == map[j][i]) {
                                map[index + 1][i] = num * 2;
                                num = 0;
                                map[j][i] = 0;
                            } else {
                                num = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = num;
                                index--;
                            }
                        }
                    }
                }
                break;
            case "left":
                for (int i = 0; i < N; i++) {
                    int num = 0;
                    int index = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] != 0) {
                            if (map[i][j] == num) {
                                map[i][index - 1] = num * 2;
                                num = 0;
                                map[i][j] = 0;
                            } else {
                                num = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = num;
                                index++;
                            }
                        }
                    }
                }
                break;
            case "right":
                for (int i = 0; i < N; i++) {
                    int num = 0;
                    int index = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            // 같은 수 있다면
                            if (num == map[i][j]) {
                                map[i][index + 1] = num * 2;
                                num = 0;
                                map[i][j] = 0;
                            } else {
                                num = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = num;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
}