import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(solve(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //여는 괄호일때 push
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(stack.isEmpty()) { // 닫는 괄호인데 pop할 원소가 없는경우
                return "NO";
            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
