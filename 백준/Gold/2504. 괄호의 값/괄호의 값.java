import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int weight = 1;
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (isOpenChar(ch)) {
                stack.push(ch);
                // ( -> 2 [ -> 3
                weight *= calculate(ch);
            } else {
                // 괄호 쌍이 맞으면? 열린게 나오면? -> 닫히면
                if (!stack.isEmpty() && isPair(stack.peek(), ch)) {
                    if (ch == ')') {
                        // 바로 닫힌거 나오면
                        if (str.charAt(i - 1) == '(') {
                            result += weight;
                        }
                        stack.pop();
                        // 2 * (내부 ) 내부가 종료 되었으니까 2를 나눠야해
                        weight /= 2;
                    }else {
                        // 바로 닫힌거 나오면
                        if (str.charAt(i - 1) == '[') {
                            result += weight;
                        }
                        stack.pop();
                        // 3 * [내부 ] 내부가 종료 되었으니까 2를 나눠야해
                        weight /= 3;
                    }
                } else {
                    result = 0;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }

    private static boolean isPair(Character peek, char ch) {
        if (peek == '(' && ch == ')') {
            return true;
        }
        if (peek == '[' && ch == ']') {
            return true;
        }
        return false;
    }

    private static int calculate(char ch) {
        if (ch == '(') {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean isOpenChar(char c) {
        return c == '(' || c == '[';
    }
}
