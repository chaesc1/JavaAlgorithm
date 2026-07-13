package Inflearn.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class ex4 {
    private List<List<Integer>> combination(int[] nums, int m) {
        return dfs(nums, m, 0, new ArrayList<>());
    }

    private List<List<Integer>> dfs(int[] nums, int m, int start, List<Integer> curr) {
        List<List<Integer>> ans = new ArrayList<>();

        /*if(curr.size() == m) {
            ans.add(new ArrayList<>(curr));
            return ans;
        }*/
        // 부분집합을 구할땐 매 순간 ans 에 추가해주면 된다. base case 필요 없음
        ans.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            ans.addAll(dfs(nums, m, i + 1, curr));
            curr.remove(curr.size() - 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        ex4 ex4 = new ex4();
        System.out.println(ex4.combination(new int[]{1, 2, 3, 4}, 2));
    }
}
