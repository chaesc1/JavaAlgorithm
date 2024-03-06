import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        while (true) {

            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }

            boolean isPalin = true;
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    isPalin = false;
                }
            }

            if (isPalin) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
