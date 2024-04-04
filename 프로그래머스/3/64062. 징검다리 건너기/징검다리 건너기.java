import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1; //최소
        int max = 200000000; //최대
        
        while(min <= max) {
            int mid = (min + max) / 2;
            
            //징검다리를 건널 수 있으면
            if(canGo(stones,k,mid)) {
                min = mid + 1;
                answer = Math.max(answer,mid);
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static boolean canGo(int[] stones, int k,int friends) {
        int jump = 0;
        
        for(int stone : stones) {
            if (stone - friends < 0) jump++;
            else jump = 0; //다시 0으로 갱신해야함
            
            if(jump == k) return false;
        }
        return true;
    }
}