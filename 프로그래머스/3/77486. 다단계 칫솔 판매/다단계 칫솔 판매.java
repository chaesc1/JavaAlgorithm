import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String,String> parent = new HashMap<>();
        
        for(int i=0; i<referral.length; i++) {
            parent.put(enroll[i],referral[i]);
        }
        
        HashMap<String,Integer> totalMap = new HashMap<>();
        
        for(int i=0; i<seller.length; i++) {
            String curName = seller[i];
            int money = amount[i] * 100; // 판매자가 판매한 금액
            
            //판매자 부터 부모 (다단계로 초대한) 한테 이동하면서 수수료를 판매자는 빼고, 부모는 더한다.
            while(money > 0 && !curName.equals("-")) {
                totalMap.put(curName, totalMap.getOrDefault(curName,0) + money - (money / 10));
                curName = parent.get(curName);
                money /= 10;
            }
        }
        
        // System.out.println(totalMap);
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            answer[i] = totalMap.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}