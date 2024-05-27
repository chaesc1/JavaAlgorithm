import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder A = new StringBuilder(br.readLine());
        StringBuilder B = new StringBuilder(br.readLine());

        while (A.length() < B.length()) {
            if(B.charAt(B.length()-1) == 'A') {
                B.deleteCharAt(B.length()-1);
            } else if (B.charAt(B.length()-1) == 'B') {
                B.deleteCharAt(B.length()-1);
                B.reverse();
            }
        }
        System.out.println(B.toString().equals(A.toString()) ? 1 : 0);
    }
}
