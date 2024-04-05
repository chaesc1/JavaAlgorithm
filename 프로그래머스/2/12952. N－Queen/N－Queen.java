import java.util.*;

class Solution {
    static int[] board;
    static int answer = 0;
    public int solution(int n) {
        board = new int[n];
        nQueen(0,n);
        return answer;
    }
    private static void nQueen(int depth,int n) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for(int i=0 ; i<n; i++) {
            board[depth] = i;
            if(isValid(depth)) {
                nQueen(depth+1,n);
            }
        }
    }
    //queen 의 직선, 대각선 false
    private static boolean isValid(int n) {
        for(int i=0; i<n; i++) {
            if(board[i] == board[n]) return false;
            else if(Math.abs(n-i) == Math.abs(board[n] - board[i])) return false;
        }
        return true;
    }
}