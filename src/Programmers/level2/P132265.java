package Programmers.level2;

import java.util.HashMap;

class Solution132265 {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>(); //형
        HashMap<Integer,Integer> map2 = new HashMap<>(); //동생

        for (int t : topping) {
            map1.put(t,map1.getOrDefault(t,0)+1);
        }
        for (int t : topping){
            map2.put(t,map2.getOrDefault(t,0)+1);

            //형 이 먹는 토핑이 동생한테 가서 0개 가 되면?
            if(map1.get(t) - 1 == 0){
                map1.remove(t);
            }else{
                map1.put(t,map1.get(t)-1); //하나 줄여서 초기화
            }

            //형과 동생이 먹는 토핑 종류가 같다면 .
            if(map1.size() == map2.size()){
                answer++;
            }
        }
        return answer;
    }
}
public class P132265 {
    public static void main(String[] args) {
        Solution132265 sol = new Solution132265();
        System.out.println(sol.solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
    }
}
