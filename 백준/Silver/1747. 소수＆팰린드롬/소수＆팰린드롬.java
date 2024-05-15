import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean isPrime = false;
        boolean isPalin = false;

        if (N == 1 || N == 2) {
            System.out.println(2);
            return;
        }
        if (N % 2 == 0) {
            N++;
        }
        //소수 구하고

        //palindrome 검사

        while (true) {
            isPrime = getPrime(N);
            isPalin = checkPalin(Integer.toString(N));
            if (isPrime && isPalin) break;
            N+=2;
        }

        System.out.println(N);
    }

    private static boolean checkPalin(String num) {
        int start = 0;
        int end = num.length()-1;

        while (start <= end) {
            if (num.charAt(start) != num.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private static boolean getPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
