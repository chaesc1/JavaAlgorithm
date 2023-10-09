package Programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

class Solution17684 {
    HashMap<String ,Integer> map = new HashMap<>();
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();

        int dicindex = 1;
        for (int i = 'A'; i <='Z' ; i++) {
            map.put(String.valueOf((char)i),dicindex++);
        }
        int index = 0;
        while (index < msg.length()){
            String word = ""; //현재입력 w
            while (index < msg.length()){
                if(!map.containsKey(word+msg.charAt(index))){
                    break;
                }else{
                    word+=msg.charAt(index);
                }
                index++;
            }
            ans.add(map.get(word));
            if(index < msg.length()){
                map.put(word+msg.charAt(index),dicindex++);
            }
            System.out.println("word = " + map.get(word));
        }
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        System.out.println(map);
        return answer;
    }
}
public class P17684 {
    public static void main(String[] args) {
        Solution17684 sol = new Solution17684();
        System.out.println("sol.solution(\"KAKAO\") = " + sol.solution("KAKAO"));
    }
}
