package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳 공부
//
public class P15230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            String input = st.nextToken();
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j)!=alpha.charAt(j)){
                    break;
                }
                count++;
            }
            System.out.println("#"+(i+1)+" "+count);
        }
    }
}
