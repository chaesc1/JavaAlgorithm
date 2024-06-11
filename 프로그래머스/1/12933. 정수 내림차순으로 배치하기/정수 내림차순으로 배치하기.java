import java.util.*;

class Solution {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        
        // 내림차순 정렬
        Arrays.sort(digits,Collections.reverseOrder());
        
        // 정렬된 숫자를 다시 하나의 문자열로 만들어
        StringBuilder sb = new StringBuilder();
        for(String digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}