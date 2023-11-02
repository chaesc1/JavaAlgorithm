package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//패턴에서 반복되는 부분을 마디라고 부른다.
// 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.
public class P2007 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String string = st.nextToken();
            for (int i = 1; i < string.length(); i++) {
                String a = string.substring(0, i);
                String b = string.substring(i, i + i);
                if(a.equals(b)){
                    System.out.printf("#%d %d\n",t,b.length());
                    break;
                }
            }
        }
    }
}
