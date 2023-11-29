package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution86052{
    public ArrayList<Integer> solution(String s){
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");

        String[] str = s.split("-");
        //추가되는 s 길이 순으로 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        for(String x : str){
            String[] temp = x.split(",");
            for (int i = 0; i < temp.length; i++) {
                int num = Integer.parseInt(temp[i]);
                if(!answer.contains(num)){
                    answer.add(num);
                }
            }
        }
        return answer;
    }
}
public class P86052 {
    public static void main(String[] args) {
        Solution64065 sol = new Solution64065();
        System.out.println("sol = " +sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println("sol = " +sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }
}
