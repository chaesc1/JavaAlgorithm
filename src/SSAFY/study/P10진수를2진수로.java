package SSAFY.study;

import java.util.Stack;

public class P10진수를2진수로 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }

    private static String solution(int num) {
        Stack<Integer> stack = new Stack<>();

        while (num > 0) {
            int remain = num % 2;
            stack.push(remain);
            num /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
