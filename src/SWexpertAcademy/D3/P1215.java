package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//ghlans
public class P1215 {
    static char[][] map;
    static int num;//회문의 길이.
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 10;  // testcase

        for (int tc = 0; tc < testcase; tc++) {
            num = Integer.parseInt(br.readLine());
            map = new char[8][8];
            sum = 0;
            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            //세로 탐색 and 가로탐색 진행
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= (8-num); j++) {
                    //세로 탐색
                    find(i,j,"cols");
                    //가로 탐색
                    find(i,j,"rows");

                }
            }
            System.out.println("#"+(tc+1)+" "+sum);
        }
    }

    public static void find(int i, int j, String s) {
        String temp = "";
        int count = 0;
        if(s.equals("cols")){
            //세로 탐색
            while (count < num){
                temp += map[j+count][i];
                count++;
            }
        }else{
            //가로탐색
            while (count < num){
                temp += map[i][j+count];
                count++;
            }
        }
        //스트링 버퍼에 temp 값 넣고 리버스
        StringBuffer sf = new StringBuffer(temp);
        String reverse = sf.reverse().toString();

        if(reverse.equals(temp)){
            //sum++;
            sum++;
        }
    }
}
