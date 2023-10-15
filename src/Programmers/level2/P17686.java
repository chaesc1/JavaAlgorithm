package Programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

class SolutionP17686{
    public String[] solution(String[] files) {
        String[] answer = {};
        //files => head , number ,tail
        //1. head 기준 정렬 ( 대 소문자 구분 안해 )
        //2. NUMBER의 숫자 순으로 정렬한다.
        // 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다.
        // 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값
        //3. 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = detach(o1);
                String[] file2 = detach(o2);

                int head = file1[0].compareTo(file2[0]);

                if(head == 0){//head 가 같다면?
                    //숫자로 비교
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return  num1 - num2;
                }else{
                    return head;
                }
            }

            private String[] detach(String str){
                String head = "";
                String number = "";
                String tail = "";

                int i = 0;
                //head
                for (; i<str.length(); i++){
                    if(str.charAt(i) >= '0' && str.charAt(i) <= '9') break;
                    head += str.charAt(i);
                }
                //number
                for(; i<str.length(); i++){
                    if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) break;
                    number += str.charAt(i);
                }
                //tail
                for(; i<str.length(); i++){
                    tail += str.charAt(i);
                }
                return new String[] {head.toLowerCase(),number,tail};
            }
        });
        return files;
    }
}
public class P17686 {
    public static void main(String[] args) {
        SolutionP17686 sol = new SolutionP17686();
        System.out.println("answer 1 = " + Arrays.toString(sol.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println("answer 2 = " + Arrays.toString(sol.solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));

    }
}
