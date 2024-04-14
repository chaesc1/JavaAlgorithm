import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] arrStack = new Stack[board.length];
        
        for(int i=0; i<arrStack.length; i++) {
            arrStack[i] = new Stack<>();
        }
        
        for(int i=board.length-1; i>=0; i--) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] > 0) {
                    arrStack[j].push(board[i][j]);
                }
            }
        }
        
        // 인형을 담을 Stack
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        
        for(int move : moves) {
            if(!arrStack[move-1].isEmpty()) {
                int doll = arrStack[move-1].pop();
                
                if(!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}