package Inflearn.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class P3 {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return -1;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                    answer++;
                }
            }

            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return -1;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                    answer++;
                }
            }

            if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return -1;
                }
                if (stack.peek() == '[') {
                    stack.pop();
                    answer++;
                }
            }
        }
        return stack.isEmpty() ? answer : -1;
    }
    public static void main(String[] args) {
        P3 solver = new P3();
        System.out.println(solver.solution("()[]{}"));
        System.out.println(solver.solution("({})"));
        System.out.println(solver.solution("{ ( ( [ ] ) ) [ ] }"));
        System.out.println(solver.solution("([)]"));
    }
}
