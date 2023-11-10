package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String find = br.readLine();
            String string = br.readLine();

            int answer = 0;
            for (int i = 0; i <= string.length()-find.length(); i++) {
                if(string.substring(i,i+find.length()).equals(find)) {
                    answer++;
                }
            }
            System.out.println("#"+t+" "+answer);
        }
    }
}
