package Inflearn.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;


// 재귀 탐색으로 구현
public class ex2_2 {
    public boolean dfs(int[] arr, int target,int m,int start, int sum, int depth) {
        if (depth == m) {
            return sum == target;
        }
        for (int i=start; i<arr.length; i++) {
            sum += arr[i];
            // 몇 개 고를지 를 알려줄 depth 변수 추가
            if (dfs(arr, target, m, i+1, sum, depth+1)) {
                return true;
            }
            sum -= arr[i];
        }
        return false;
    }

    public boolean solution(int[] a, int target, int m) {
        // 리스트에서 m 개의 요소의 합이 target 이 되면 true 반환
        return dfs(a, target,m,0,0,0);
    }
    public static void main(String[] args) {
        ex2_2 solution = new ex2_2();
        //System.out.println(Arrays.toString(solution.solution(new int[]{4, 9, 7, 5, 1}, 16,3)));
        System.out.println(solution.solution(new int[]{4, 9, 7, 5, 1}, 13,3));
    }
}
