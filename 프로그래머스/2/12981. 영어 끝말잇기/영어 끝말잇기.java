import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        //이미 사용한 단어
        HashSet<String> usedWord = new HashSet<>();
        
        char prev = words[0].charAt(0); // 이전 사람의 마지막 단어
        for(int i=0; i<words.length; i++) {
            //이미 사용한 단어거나, 끝단어 != 시작단어 인경우
            if(usedWord.contains(words[i]) || words[i].charAt(0) != prev) {
                return new int[] {(i%n)+1,(i/n)+1};
            }
            usedWord.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
        }
    
        return new int[] {0,0};
    }
}