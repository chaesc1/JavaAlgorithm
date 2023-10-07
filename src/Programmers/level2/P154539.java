package Programmers.level2;


import java.util.Stack;

class Solution154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=numbers.length-1; i>=0; i--){
            while (!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    answer[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = -1;
            }
            stack.push(numbers[i]);
        }

        return answer;
    }
}
public class P154539 {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        Solution154539 sol = new Solution154539();
        System.out.println("sol.solution(numbers) = " + sol.solution(numbers));
    }
}
