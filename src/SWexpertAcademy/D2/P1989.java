package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//초심자의 회문검사
public class P1989 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine().trim();
//            System.out.println("s = " + s);
            int res = 1;
            for (int j = 0; j < s.length()/2 + 1; j++) {
                if(s.charAt(j) != s.charAt(s.length()-j-1)){
                    res = 0;
                    break;
                }
            }
            System.out.println("#"+(i+1)+" "+res);
        }
    }
}
