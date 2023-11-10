package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1216 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[100][100];
        for (int t = 0; t < 10; t++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            int MAX = 0;
            StringBuilder sb = new StringBuilder();
            String tmp = " ";

            //가로 회문 탐색 or 세로 회문 탐색 시작
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sb.setLength(0);
                    for (int k = j; k < 100; k++) {
                        sb.append(map[i][k]);
                        tmp = sb.toString(); //sb값 복사

                        if (tmp.equals(sb.reverse().toString())){ // 복사값이 뒤집은 sb와 같으면 ? => 회문
                            MAX = Math.max(tmp.length(),MAX);
                            sb.reverse();// 다시 뒤집어
                        } else {
                            sb.reverse();
                        }
                    }
                }
            }
            //세로 회문 탐색
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sb.setLength(0);
                    for (int k = j; k < 100; k++) {
                        sb.append(map[k][i]);
                        tmp = sb.toString(); //sb값 복사
                        if (tmp.equals(sb.reverse().toString())){ // 복사값이 뒤집은 sb와 같으면 ? => 회문
                            MAX = Math.max(tmp.length(),MAX);
                            sb.reverse();// 다시 뒤집어
                        } else {
                            sb.reverse();
                        }
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+MAX);
        }
    }

}
