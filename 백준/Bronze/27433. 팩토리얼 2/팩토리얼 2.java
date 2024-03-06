import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));
    }

    private static long factorial(int n) {
        if (n==0 || n==1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
