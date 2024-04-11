import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        //수포자들이 찍는 패턴        
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        //각각 수포자들의 점수
        int[] scores = new int[3];
        
        //얼마나 일치하는지
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<patterns.length; j++) {
                if(answers[i] == patterns[j][i % patterns[j].length]){
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<scores.length; i++) {
            if(scores[i] == maxScore) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}