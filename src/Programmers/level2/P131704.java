package Programmers.level2;

import java.util.Stack;

class SolutionP131704{
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack1 = new Stack<>();//메인 스택

        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            boolean flag = false;
            //꺼낸 택배가 순서에 맞으면?
            if(order[idx] == i){
                idx++;
                answer++;
                flag = true;
            }
            //꺼낸 택배 상자가 맞지 않아 보조 컨베이어 밸트에서 꺼낸 박스가 일치하면 계속 꺼내
            while (!stack1.isEmpty() && stack1.peek() == order[idx]){
                stack1.pop();
                idx++;
                answer++;
                flag = true;
            }

            if(!flag){
                stack1.add(i);
            }
        }
        while (!stack1.isEmpty() && stack1.peek() == order[idx]){
            stack1.pop();
            idx++;
            answer++;
        }

        return answer;
    }
}
public class P131704 {
    public static void main(String[] args) {
        SolutionP131704 sol = new SolutionP131704();
        int[] order = {5,4,3,2,1};
//        System.out.println(sol.solution(new int[] {4,3,1,2,5}));
        System.out.println(sol.solution(order));

    }
}
