package Programmers.level3;

//보석 쇼핑 -> 카카오 인턴십
//진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution67258{
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        //보석 종류만
        HashSet<String> kinds = new HashSet<>(Arrays.asList(gems));

        //key = 보석 value = 보석 갯수
        HashMap<String,Integer> maps = new HashMap<>();
        //종류가 하나면 return [1,1]
        if(kinds.size() == 1) return new int[] {1,1};
        int start = 0; //시작지점은 0으로 잡아
        int length = Integer.MAX_VALUE; //최솟값 구하기 위해 구간 길이를 크게 잡고 시작
        int end = 0;
        //
        for (int i = 0; i < gems.length; i++) {
            //보석이 없으면 1, 있으면 기존 개수에 1개 추가 .
            maps.put(gems[i],maps.getOrDefault(gems[i],0)+1);
            System.out.println("maps = " + maps);
            //start 번째 보석이 이미 들어 있는 보석 이라면?
            while (maps.get(gems[start]) > 1){
                maps.put(gems[start],maps.get(gems[start])-1); //해당 보석갯수를 -1 하고
                start++;//시작지점을 +1
                System.out.println(start+" "+i);
            }
            if(maps.size() == kinds.size() && length > (i-start)){
                length = i- start;
                answer[0] = start+1;
                answer[1] = i+1;
            }
        }
//        System.out.println("kinds = " + kinds);
//        System.out.println("maps = " + maps);
        return answer;
    }
}
public class P67258 {
    public static void main(String[] args) {
        Solution67258 sol = new Solution67258();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println("sol.solution(gems) = " + Arrays.toString(sol.solution(gems)));
    }
}
