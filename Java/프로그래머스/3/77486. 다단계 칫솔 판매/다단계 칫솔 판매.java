import java.util.*;

class Solution {
    // 사람 : 추천인
    Map<String, String> parentMap = new HashMap<>();
    // 사람 : 누적이익
    Map<String, Integer> profit = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i=0; i<enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);; // 누적이익은 0으로 초기화
        }
        
        for(int i=0; i<seller.length; i++) {
            // 칫솔 100원 
            distribute(seller[i], amount[i] * 100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
    
    public void distribute(String person, int money) {
        if(person.equals("-")) return; // 더이상 위로 갈 수 없음
        
        // 위로 나눠줘야 하는 금액 => money / 10
        int share = money / 10;
        
        if (share == 0) {
            profit.put(person, profit.get(person) + money); // 전부 자기 몫
            return;
        }
        
        profit.put(person, profit.get(person) + (money - share)); // 90 프로는 내 몫
        distribute(parentMap.get(person), share); // 10퍼센트는 추천인에게 재귀로 전달.
    }
}