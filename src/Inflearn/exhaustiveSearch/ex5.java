package Inflearn.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class ex5 {
    private List<List<Integer>> combination(int[] nums) {
        return dfs(nums, new ArrayList<>(), 0);
    }

    private List<List<Integer>> dfs(int[] nums, List<Integer> curr, int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        // base case
        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        ans.addAll(dfs(nums, curr, idx+1));

        curr.add(nums[idx]);
        ans.addAll(dfs(nums, curr, idx+1));
        curr.remove(curr.size()-1);
        return ans;
    }


    public static void main(String[] args) {
        ex5 ex5 = new ex5();
        System.out.println(ex5.combination(new int[]{1, 2, 3, 4}));
    }
}
