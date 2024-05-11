import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);

            // 3, 6 ,9 있는지
            if (num.contains("3") || num.contains("6") || num.contains("9")) {
                for (int j = 0; j < num.length(); j++) {
                    if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            } else {
                System.out.print(i +" ");
            }
        }

    }
}