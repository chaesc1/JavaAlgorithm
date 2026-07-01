import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // 스택 -> 이전 가격, 현재 가격 비교
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 첫 인덱스 삽입
        
        for (int i=1; i<n; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 가격이 떨어졌으니 pop (인덱스 뺴고, 길이 구해 )
                int lastIndex = stack.pop();
                answer[lastIndex] = i - lastIndex;
            }
            
            stack.push(i);
        }
        // 끝까지 안떨어진 항목
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - j - 1;
        }
        return answer;
    }
}