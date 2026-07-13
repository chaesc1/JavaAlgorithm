package Inflearn.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {

    public int solution(int[] prices, int target) {
        int count = 0;
        Map<Integer, Integer> seen = new HashMap<>();

        /*for (int price : prices) {
            int complement = target - price;
            count += seen.getOrDefault(complement, 0);
            seen.merge(price, 1, Integer::sum);
        }*/

        // two pointer 풀이
        Arrays.sort(prices);

        int left = 0;
        int right = prices.length - 1;
        while(left < right) {
            if (prices[left] + prices[right] < target) {
                left++;
            } else if (prices[left] + prices[right] > target) {
                right--;
            } else {
                count++;
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        P1 solver   = new P1();

        System.out.println(solver.solution(new int[]{4, 1, 9, 7, 5, 3, 16}, 14)); // 1
        System.out.println(solver.solution(new int[]{2, 1, 5, 7}, 4)); // 0
    }
}
