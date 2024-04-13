import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            answer[i] = numbers[i];        
        }
        
        for(int i=0; i<numbers.length; i++) {
            String binaryString = Long.toBinaryString(numbers[i]);
            // System.out.println(binaryString);
            if(numbers[i] % 2 == 0) { 
                answer[i] = numbers[i] + 1;
            }
            else {
                int lastIdx = binaryString.lastIndexOf("0");
                int oneIdx = binaryString.indexOf("1",lastIdx); // 0이 나오는 인덱스까지의 1의index?
                if(lastIdx == -1) {
                    binaryString = Long.toBinaryString(numbers[i] + 1);
                    binaryString = binaryString.substring(0,2) + binaryString.substring(2,binaryString.length()).replace("0","1");
                } else {
                    // 1 이 존재하는 숫자면?
                    binaryString = binaryString.substring(0,lastIdx) + "1" + binaryString.substring(lastIdx + 1, oneIdx) + "0" + binaryString.substring(oneIdx+1,binaryString.length());
                }
                answer[i] = Long.parseLong(binaryString,2);
            }
        }
        return answer;
    }
}