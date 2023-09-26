package Programmers.level2;
//연속 부분 수열 합의 개수 구하기
import java.util.*;
public class P01 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        Set<Integer> set = new HashSet<>(); //정답에는 중복이 없어..!
        int[] newElements = new int[elements.length*2];
        // 7 9 1 1 4 => 7 9 1 1 4 1 1 9 7
        for(int i = 0; i < elements.length; i++) {
            newElements[i] = newElements[i + elements.length] = elements[i];
        }
        for (int i = 0; i < elements.length; i++) { //1-5까지
            int sum = 0;
            // 자기 자신부터, 원소의 길이만큼 더하기
            for (int j = i; j < i+elements.length; j++) {
                sum += newElements[j];
                set.add(sum);
            }
        }
        System.out.println(set.size());
    }
}
