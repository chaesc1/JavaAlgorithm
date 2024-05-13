package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1215_Re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 10;

        for (int i = 1; i <= tc; i++) {
            int numOfPalin = Integer.parseInt(br.readLine()); // 회문의 길이
            char[][] map = new char[8][8];
            int answer = 0;

            //배열 입력하고
            for (int j = 0; j < 8; j++) {
                String line = br.readLine();
                for (int k = 0; k < 8; k++) {
                    map[j][k] = line.charAt(k);
                }
            }

            boolean flag;
            // 행 기준 탐색
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map.length - numOfPalin + 1; k++) {
                    flag = true;
                    for (int l = 0; l < numOfPalin / 2; l++)
                        if (map[j][k + l] != map[j][k - l + numOfPalin - 1]) {
                            flag = false;
                        }
                    if (flag) {
                        answer++;
                    }
                }
            }

            // 열 기준 탐색
            for (int j = 0; j < map.length - numOfPalin + 1; j++) {
                for (int k = 0; k < map.length; k++) {
                    flag = true;
                    for (int l = 0; l < numOfPalin / 2; l++)
                        if (map[j + l][k] != map[j - l + numOfPalin - 1][k])
                            flag = false;

                    if (flag) answer++;

                }
            }
            System.out.println("#" + i + " " + answer);
        }

    }
}
