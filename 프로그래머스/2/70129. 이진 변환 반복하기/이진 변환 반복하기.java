import java.util.*;

class Solution {
    public int[] solution(String s) {
        //이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수
        int countTransform = 0;
        int countZero = 0;
        int[] answer = {};
        
        while(!s.equals("1")) {
            countTransform++;
            int zero = s.replace("1","").length(); // 1을 제거한 수의 길이 = 0의 개수
            countZero += zero;
            // 1의 개수를 카운트 하고 이진수로 변환
            s = Integer.toBinaryString(s.length() - zero);
        }
        return new int[] {countTransform, countZero};
    }
}