package Programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

//Dynamic Programming ???

class Solution12971{
    static int[] dp1;
    static int[] dp2;
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;

        //처음을 뜯는 경우 dp table
        dp1 = new int[n];
        //처음을 뜯지 않는 dp table
        dp2 = new int[n];

        if(n == 1){ // 원소가 한개면 첫번째 값이 answer
            return sticker[0];
        }

        //처음을 뜯는 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        //3번째 원소부터 마지막 제외 하고 loop
        for (int i = 2; i < n-1; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(dp1[i]);
//        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp2[i]);
        }
        return Math.max(dp1[n-2],dp2[n-1]);
    }
}
public class P12971 {
    public static void main(String[] args) {
        Solution12971 sol = new Solution12971();
        int[] stickers = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(sol.solution(stickers));
    }
}
