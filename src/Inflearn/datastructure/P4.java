package Inflearn.datastructure;

import java.util.Arrays;
import java.util.Stack;

// 스쿼트에 진심인 피트니스 매니아가 매일 최대 중량 기록을 측정하고 있습니다.
//
//그의 목표는 더 무거운 무게를 드는 날을 지속적으로 만들어가는 것입니다.
//
//매일의 스쿼트 최대 중량 기록이 정수 배열 weights로 주어졌을 때, 각 날의 중량보다 더 높은 중량을 든 날까지 걸린 일수를 계산하여 배열로 반환하는 solution 함수를 작성하세요. 만약 이후에 더 높은 중량을 들지 못했다면 해당 값은 0으로 설정합니다.
public class P4 {
    public int[] solution(int[] weights) {
        int[] answer = new int[weights.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < weights.length; i++) {
            while (!stack.isEmpty() && weights[stack.peek()] < weights[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        P4 p = new P4();
        System.out.println(Arrays.toString(p.solution(new int[]{25, 23, 31, 28, 25, 25, 27, 29})));
        System.out.println(Arrays.toString(p.solution(new int[]{45,42,50,48,46,52,49})));
    }
}
