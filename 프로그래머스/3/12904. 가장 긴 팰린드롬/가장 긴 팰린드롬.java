import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        //단일 문자면 true
        if(s.length() == 1) return 1;
        
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                answer = Math.max(answer, isPalin(s,i,i-1));
            }
            
            if(i>1 && s.charAt(i) == s.charAt(i-2)) {
                answer = Math.max(answer, isPalin(s,i-2,i));
            }
        }
        
        return answer;
    }
    public static int isPalin(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        
        return end-start-1;
    }
}