import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int numLeft = a[0];
        int numRight = a[a.length-1];
        
        for(int i=1; i<a.length - 1; i++) {
            if(numLeft > a[i]) numLeft = a[i];
            left[i] = numLeft;
        }
        
        for(int i=a.length-2; i>0; i--) {
            if(numRight > a[i]) numRight = a[i];
            right[i] = numRight;
        }
    
        int answer = 2;
        if(a.length == 1) answer = 1;
        
        for(int i=1; i<a.length-1; i++) {
            if(a[i] > left[i] && a[i] > right[i]) continue;
            answer++;
        }
        
        return answer;
    }
}