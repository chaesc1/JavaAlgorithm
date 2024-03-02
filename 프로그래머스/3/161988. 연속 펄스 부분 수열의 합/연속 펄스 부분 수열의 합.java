import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long one = 1;
        long two = -1;
        long caseOne = sequence[0];
        long caseTwo = sequence[0] * -1;
        long max = Long.MIN_VALUE;
        long minOne = 0;
        long minTwo = 0;
        
        for(int i=1; i<=sequence.length; i++) {
            one *= -1;
            two *= -1;
            
            max = Math.max(max,caseOne - minOne);
            max = Math.max(max,caseTwo - minTwo);
            
            minOne = Math.min(minOne,caseOne);
            minTwo = Math.min(minTwo,caseTwo);
            
            if(i==sequence.length) break;
            caseOne += sequence[i] * one;
            caseTwo += sequence[i] * two;

        }
        return max;
    }
}