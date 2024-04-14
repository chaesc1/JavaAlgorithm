import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        //이전 가격과 현재 가격을 비교 - price 의 인덱스를 담아
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for(int i=1; i<prices.length; i++) {
            //prices[stack.peek()] > prices[i] -> 감소하는 구간
            //prices[stack.peek()] < prices[i] -> 증가하는 구간
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int day = stack.pop();
                
                answer[day] = i - day; // 가격이 떨어진 경우 바로 answer에 삽입
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int j = stack.pop();
            
            answer[j] = prices.length - 1 - j;
        }
        return answer;
    }
}