import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        //수식 입력받아
        String str = br.readLine();
        //연산자가 아닌 경우 출력

        //연산자는 stack에 삽입 -> 연산자 우선순위를 따져
        // (
        // + -
        // * /

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            switch (now) {
                //연산자면??
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && isPriority(stack.peek()) >= isPriority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                    break;
                case '(': // 여는 괄호면
                    stack.push(now);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(now); // 피연산자 출력
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    //우선순위판별
    private static int isPriority(char ch) {
        if (ch == '(' || ch == ')') {
            return 0;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '/' || ch == '*') {
            return 2;
        }
        return -1;
    }
}
