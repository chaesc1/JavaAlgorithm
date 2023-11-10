package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1은 N극 성질을 가지는 자성체를 2는 S극 성질을 가지는 자성체를 의미하며
// 테이블의 윗부분에 N극이 아래부분에 S극이 위치한다고 가정한다.
public class P1220 {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            map = new int[100][100];

            StringTokenizer st;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    // 1은 N 극 / 2는 S극 성질.
                    // 테이블 위는 N 극 - 성질 아래는 S 성질 ---> 1은 아래로 2는 위로 가려고 해
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < 100; i++) {
                int status = 0; // 상태 저장 변수
                for (int j = 0; j < 100; j++) {
                    if (map[j][i] == 1) {
                        status = 1;
                    } else if (map[j][i] == 2) {
                        if (status == 1) {
                            count++;
                        }
                        status = 2;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
