import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int length = s.length();
        s += s; //좌로 이어 붙힌 경우
        
        A:for(int i=0; i<length; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(int j=i; j<i+length; j++) {
                char ch = s.charAt(j);
                //열리는 괄호면 스택에 삽입
                if(!map.containsKey(ch)) {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
                        continue A;
                    }
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}