import java.util.*;

class Solution {
    //처음 표의 행 개수를 나타내는 정수 n, 처음에 선택된 행의 위치를 나타내는 정수 k, 수행한 명령어들이 담긴 문자열 배열 cmd
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> remove_order = new Stack<>();
        int stack_size = n; // n으로 시작
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            
            if(c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            } else if(c == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if(c == 'C') {
                remove_order.add(k);
                stack_size--;
                if(stack_size == k) {
                    k--;// 마지막 행이면 인덱스 위로 이동
                }
            } else if(c == 'Z') {
                if(remove_order.pop()<=k) {
                    k++;
                }
                stack_size++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stack_size; i++) {
            sb.append("O");
        }
        while(!remove_order.isEmpty()) {
            sb.insert(remove_order.pop().intValue(),"X");
        }
        
        return sb.toString();
    }
}