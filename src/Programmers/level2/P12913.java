package Programmers.level2;

class Solution12913{
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];

        //dp의 첫줄을 land의 첫 줄로 초기화
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                for (int k = 0; k < land[0].length; k++) {
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+land[i][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print("dp[i] = " + dp[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(dp[land.length-1][i],answer);
        }

        return answer;
    }
}
public class P12913 {
    public static void main(String[] args) {
        Solution12913 sol = new Solution12913();
        System.out.println("sol.solution(new int[]) = " + sol.solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
