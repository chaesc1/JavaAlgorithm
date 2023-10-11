package Programmers.level2;

import java.util.Arrays;

class SolutionP17686{
    public String[] solution(String[] files) {
        String[] answer = {};

        for(String s: files){
            String temp = s;
        }
        return answer;
    }
}
public class P17686 {
    public static void main(String[] args) {
        SolutionP17686 sol = new SolutionP17686();
        System.out.println("answer 1 = " + Arrays.toString(sol.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println("answer 2 = " + Arrays.toString(sol.solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));

    }
}
