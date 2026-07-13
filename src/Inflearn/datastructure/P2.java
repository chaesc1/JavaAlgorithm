package Inflearn.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2 {
    public int solution(String s) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                // 닫힘 괄호 일 경우
                // 첫 시작이 닫힘괄호 즉 stack isEmpty
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
                answer++;
            }
        }
        return stack.isEmpty() ? answer : -1;
    }
    public static void main(String[] args) {
        P2 solver = new P2();
        System.out.println(solver.solution("(("));
        System.out.println(solver.solution("(()())()"));
    }
}
