package Programmers.level1;

import java.util.HashSet;

class Solution1845 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hash = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            hash.add(nums[i]);
        }
        if((nums.length/2) > hash.size()){
            return hash.size();
        }
        return nums.length/2;
    }
}
public class P1845 {
    public static void main(String[] args) {
        Solution1845 sol = new Solution1845();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(sol.solution(nums));
    }
}
