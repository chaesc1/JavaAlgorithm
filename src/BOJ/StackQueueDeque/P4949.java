package BOJ.StackQueueDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {
            s = br.readLine();
            
            if (s.equals(".")) {
                break;
            }
            
            sb.append(solve(s)).append("\n");
        }
        System.out.println(sb);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);//한글자씩

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if ( ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if ( ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }

}
