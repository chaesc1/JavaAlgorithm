package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
//
//#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다
public class P1218 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for (int t = 1; t <= 10; t++) {
            int result = 1;
            int len = Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == ')' && stack.peek() == '(') stack.pop();
                else if (ch == '}' && stack.peek() == '{') stack.pop();
                else if (ch == ']' && stack.peek() == '[') stack.pop();
                else if (ch == '>' && stack.peek() == '<') stack.pop();
                else {
                    stack.add(ch);
                }
            }

            if (stack.isEmpty()) result = 1;
            else result = 0;

            sb.append("#"+t).append(" "+result).append("\n");

        }
        System.out.print(sb);
    }
}
