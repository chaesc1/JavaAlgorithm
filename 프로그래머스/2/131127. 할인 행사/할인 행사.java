import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i],number[i]);
        }
        int answer = 0; // 총 일수를 Count 10일 동안
        for(int i=0; i<discount.length - 9; i++) {
            HashMap<String,Integer> discountMap = new HashMap<>();
            for(int j=i; j<i+10; j++) {
                if(wantMap.containsKey(discount[j])) {
                    discountMap.put(discount[j],discountMap.getOrDefault(discount[j],0)+1);
                }
            }
            
            if(wantMap.equals(discountMap)) {
                answer++;
            }   
        }
        
        
        return answer;
    }
}