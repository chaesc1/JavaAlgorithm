package Programmers.level2;

import java.util.HashMap;
import java.util.Map;

class Solution131127{
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i],number[i]);
        }
        System.out.println("map = " + map);
        //discount map 생성후 처음 10일치 집어넣어
        HashMap<String,Integer> disMap = new HashMap<>();
        for (int i = 0; i < days; i++) {
            disMap.put(discount[i],disMap.getOrDefault(discount[i],0)+1);
        }
        //첫날 카운트
        if(isEqual(map,disMap)){
            answer++;
        }
        for (int i = 1; i <discount.length-days+1; i++) {
            String deleteItem = discount[i-1]; //해시 처음 들어간 값
            //첫번째 제거
            disMap.put(deleteItem,disMap.get(deleteItem)-1);

            String addItem = discount[i+days-1];
            disMap.put(addItem,disMap.getOrDefault(addItem,0)+1);

            if(isEqual(map,disMap)){
                answer++;
            }
        }
        return answer;
    }

    public boolean isEqual(HashMap<String, Integer> map, HashMap<String, Integer> disMap) {
        for(String key:map.keySet()){
            if(!disMap.containsKey(key) || map.get(key) != disMap.get(key)){
                return false;
            }
        }
        return true;
    }
}
public class P131127 {
    public static void main(String[] args) {
        Solution131127 sol = new Solution131127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] num = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(sol.solution(want,num,discount));
    }
}
