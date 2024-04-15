import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;
        
        for(int i=0; i<s.length; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            for(int j=0; j<s[i].length(); j++) {
                char ch = str.charAt(j);
                
                stack.push(ch);
                if(stack.size() >= 3) {
                    char first = stack.pop();
                    if(first != '0') {
                        stack.push(first);
                        continue;
                    }
                    char second = stack.pop();
                    if(second != '1') {
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    char third = stack.pop();
                    if(third != '1') {
                        stack.push(third); // 1
                        stack.push(second);// 1
                        stack.push(first); // 0
                        continue;
                    }
                    
                    cnt++; // 110 개수
                }   
            }
            sb = new StringBuilder();
            int position = stack.size();
            boolean isZero = false;
            while(!stack.isEmpty()) {
                char pop = stack.pop();
                // 0이 나올때까지 pop
                if(!isZero && pop != '0') position--;
                if(pop == '0') isZero = true;
                sb.insert(0,pop);
            }
            
            for(int j=0; j<cnt; j++) {
                sb.insert(position,"110");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}