package Programmers.level3;
//동적 계획법
//arr_triangle
//0-     7
//1-    3 8
//2-   8 1 0
//3-  2 7 4 4
//4- 4 5 2 6 5

//arr_dp
//0- 7
//1- 10 15
//2- 18 16 15
//3- 20 2

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; //처음
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; //마지막
            for (int j = 1; j < i; j++) {//중간 값
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
                answer = Math.max(answer,dp[i][j]);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
public class P43105 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr_triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        s.solution(arr_triangle);
    }
}
