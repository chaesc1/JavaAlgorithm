package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1926 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String temp = String.valueOf(i);

            if(temp.contains("3") || temp.contains("6") || temp.contains("9")){
                for (int j = 0; j < temp.length(); j++) {
                    if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9'){
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            }else{
                System.out.print(i+" ");
            }
        }
    }
}
