package Programmers.level2;
//2차원 행렬 arr1과 arr2를 입력받아,
// arr1에 arr2를 곱한 결과를 반환하는 함수,
// solution을 완성해주세요.
import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //arr1 행 길이
        int arr1_row = arr1.length;
        //arr1 열 길이
        int arr1_col = arr1[0].length;
        //arr2 열 길이
        int arr2_col = arr2[0].length;
        int[][] answer = new int[arr1_row][arr2_col];
        for (int i = 0; i < arr1_row; i++) {
            for (int j = 0; j < arr2_col; j++) {
                int sum = 0;
                for (int k = 0; k < arr1_col; k++) {
                    sum+=arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
                System.out.println(answer[i][j]);

            }
        }
        return answer;

    }
}

//Main 클래스에서 Solution클래스 선언해주기
public class P03 {
    public static void main(String[] ars) {
        Solution s = new Solution();
        //입력요소를 선언해줘야 출력값이 나옴
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        s.solution(arr1,arr2);
    }
}