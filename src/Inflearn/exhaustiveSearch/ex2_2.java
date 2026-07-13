package Inflearn.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;


// 재귀 탐색으로 구현
public class ex2_2 {
    public boolean dfs(int[] arr, int target,int m,int start, List<Integer> selected) {
        // basecase , 최송상태. 선택된 요소의 개수 가 M 일때
        if (selected.size() == m) {
            // 리스트 에 있는 모든 수 더해서 target 과 비교
            int sum = 0;
            for (int n : selected) {
                sum += n;
            }
            return sum == target;
        }
        for (int i = start; i < arr.length; i++) {
            selected.add(arr[i]);
            if (dfs(arr, target, m, i, selected)) {
                return true;
            }
            // 재귀 호출이 끝나면 원상 복구 해줘야한다.
            selected.remove(selected.size()-1);
        }
        return false;
    }

    public boolean solution(int[] a, int target, int m) {
        return dfs(a, target,m,0, new ArrayList<>());
    }
    public static void main(String[] args) {
        ex2_2 solution = new ex2_2();
        //System.out.println(Arrays.toString(solution.solution(new int[]{4, 9, 7, 5, 1}, 16,3)));
        System.out.println(solution.solution(new int[]{4, 9, 7, 5, 1}, 13,3));
    }
}
