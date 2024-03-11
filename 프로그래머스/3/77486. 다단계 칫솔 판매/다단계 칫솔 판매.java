import java.util.*;

/*
민호는 center 
각각의 자신은 본인의 부모 노드에게 연결된 트리구조
판매에 의해 발생하는 이익의 10프로를 부모에게 배분, 나머지는 본인이 가짐
1원 미만일 경우 이득 분배 X, 자신이 모두 가짐 
*/
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //referral 을 준 이유????????
        HashMap<String,Integer> sellerMap = new HashMap<>(); // 인원 , 수익
        HashMap<String,String> referralMap = new HashMap<>(); // 인원 , 수익
        for(int i=0; i<enroll.length; i++) {
            referralMap.put(enroll[i],referral[i]);
            sellerMap.put(enroll[i],0);        
        }
        
        
        for(int i=0; i<seller.length; i++) {
            String man = seller[i];
            int money = amount[i] * 100; // 벌어들인 돈
            int commission = money / 10; // 수수료
            int earn = money - commission; // 벌어들인 돈 - 수수료
            
            if(referralMap.containsKey(man)) {
                sellerMap.put(man, sellerMap.get(man) + earn);
                while(!referralMap.get(man).equals("-")) {
                    man = referralMap.get(man);
                    if (money == 0) break;
                    else money /= 10;
                    commission = money / 10;
                    earn = money - commission;
                    sellerMap.put(man, sellerMap.get(man) + earn);
                }
            }
        }
        
        int[] answer = new int[enroll.length];
        int index = 0;
        for(String enrolls : enroll) {
            answer[index++] = sellerMap.get(enrolls);
        }
        return answer;
    }
}