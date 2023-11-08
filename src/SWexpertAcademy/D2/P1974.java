package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1974 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[][] map = new int[9][9];
            boolean isFlag = true;

            //배열 입력
            StringTokenizer st;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //행체크
            for (int i = 0; i < 9; i++) {
                int[] arr = new int[9];
                for (int j = 0; j < 9; j++) {
                    arr[(map[i][j] - 1)]++;
                }
                for (int j = 0; j < 9; j++) {
                    if (arr[j] == 0) {
                        isFlag = false;
                        break;
                    }
                }
            }
            //열체크
            for (int i = 0; i < 9; i++) {
                int[] arr = new int[9];
                for (int j = 0; j < 9; j++) {
                    arr[(map[j][i] - 1)]++;
                }
                for (int j = 0; j < 9; j++) {
                    if (arr[j] == 0) {
                        isFlag = false;
                        break;
                    }
                }
            }
            //격자체크
            for (int i = 0; i <= 6; i+=3) {
                for (int j = 0; j <= 6; j+=3) {
                    int[] arr = new int[9];
                    int r = i + 3;
                    int c = j + 3;

                    for (int k = i; k < r; k++) {
                        for (int l = j; l < c; l++) {
                            arr[map[k][l] - 1]++;
                        }
                    }
                    for (int k = 0; k < 9; k++) {
                        if (arr[k] == 0) {
                            isFlag = false;
                            break;
                        }
                    }
                }
            }
            if (isFlag) {
                System.out.println("#" + tc + " " + "1");
            } else {
                System.out.println("#" + tc + " " + "0");
            }
        }
    }
}
