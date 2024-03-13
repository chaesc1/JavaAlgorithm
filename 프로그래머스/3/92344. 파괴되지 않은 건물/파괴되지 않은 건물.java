import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        
        int[][] sum = new int[row+1][col+1];
        for(int[] sk : skill) {
            int type = sk[0];
            if (type == 1) {
                //적의 공격
                sum[sk[1]][sk[2]] -= sk[5];
                sum[sk[3]+1][sk[4]+1] -= sk[5];
                sum[sk[1]][sk[4]+1] += sk[5];
                sum[sk[3]+1][sk[2]] += sk[5];
            } else {
                //아군의 회복
                sum[sk[1]][sk[2]] += sk[5];
                sum[sk[3]+1][sk[4]+1] += sk[5];
                sum[sk[1]][sk[4]+1] -= sk[5];
                sum[sk[3]+1][sk[2]] -= sk[5];
            }            
        }
        for(int i=0; i<row+1; i++) {
            for(int j=0; j<col; j++ ) {
                sum[i][j+1] += sum[i][j];
            }
        }
            
        for(int i=0; i<col+1; i++) {
            for(int j=0; j<row; j++ ) {
                sum[j+1][i] += sum[j][i];
            }
        }
        
//         for(int[] s : sum) {
//             for(int n : s) {
//                 System.out.print(n + " ");
//             }
//             System.out.println();
//         }
        
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++ ) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}