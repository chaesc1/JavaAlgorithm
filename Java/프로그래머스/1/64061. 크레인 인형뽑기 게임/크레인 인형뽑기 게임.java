import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] stack = new Stack[board.length];
        for(int i=0; i<stack.length; i++) {
            stack[i] = new Stack<>();
        }
        
        for(int i=board.length-1; i>=0; i--) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] > 0) {
                    stack[j].push(board[i][j]);
                }
            }
        }
        
        // 인형을 뽑아 담을 basket 
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        
        for(int move : moves) {
            // 해당 열에 숫자가 있으면
            if(!stack[move-1].isEmpty()) { 
                int doll = stack[move-1].pop();
                
                // 바구니에 인형이 있고, 가장 위에 있는 인형과 같은경우
                if(!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }
        return answer;
    }
}