// 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
// 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
// 심사관은 1명 이상 100,000명 이하입니다.
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 심사 시간 정렬 
        
        long max = (long) times[times.length-1] * n;
        long min = 1;
        long mid = 0;
        long sum;
        long answer = max;
        
        while(min <= max) {
            sum = 0;
            mid = (min + max) / 2;
            for(int time : times) {
                sum += mid/time;
            }
            
            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }            
        }
        
        return answer;
    }
}