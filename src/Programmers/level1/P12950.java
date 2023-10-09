package Programmers.level1;


class Solution12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
                System.out.println(answer[i][j]);
            }
        }
        return answer;
    }
}
public class P12950 {
    public static void main(String[] args) {
        int[][] arr1 = {{1},{2}};
        int[][] arr2 = {{3},{5}};

        Solution12950 sol = new Solution12950();
        System.out.println("sol.solution(arr1,arr2) = " + sol.solution(arr1,arr2));
    }
}
