package Programmers.level2;

import java.util.ArrayList;

class Solution17677{
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //두개의 list 선언
        ArrayList<String> Alist = new ArrayList<>();
        ArrayList<String> Blist = new ArrayList<>();

        //합집합 and 교집합 리스트
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersect = new ArrayList<>();

        //1. str1 을 두개씩 잘라
        // 오로지 영문자로 된것만 리스트에 넣어
        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            //두 문자가 모두 영어면 리스트에 삽입 logic
            if(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z'){
                Alist.add(String.valueOf(ch1)+String.valueOf(ch2));
            }
        }
        //2. str2 를 두개씩 잘라
        // 오로지 영문자로 된것만 리스트에 넣어
        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            //두 문자가 모두 영어면 리스트에 삽입 logic
            if(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z'){
                Blist.add(String.valueOf(ch1)+String.valueOf(ch2));
            }
        }

        //교집합
        System.out.println("Alist = " + Alist);
        for(String s : Alist){
            if(Blist.remove(s)) {//즉 blist 의 값이 Alist 값에 의해 지워진다면? -> 교집합이라는 뜻
                //Blist 에서 지우
                intersect.add(s);
            }
            System.out.println("intersect = " + intersect);
            union.add(s); //남은 Alist 삽입
        }
        //Blist 에 남은 문자도 넣어줘
        for (int i = 0; i < Blist.size(); i++) {
            union.add(Blist.get(i));
        }
        //자카드 유사도
        double jacard = (double)(intersect.size()) / (double) (union.size());
        jacard *= 65536;
        //합집합이 공집합
        if(union.size() == 0){
            return 65536;
        }
        answer = (int)jacard;
        return answer;
    }
}
public class P17677 {
    public static void main(String[] args) {
        Solution17677 sol = new Solution17677();
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        System.out.println("sol = " + sol.solution(str1,str2));
    }
}
