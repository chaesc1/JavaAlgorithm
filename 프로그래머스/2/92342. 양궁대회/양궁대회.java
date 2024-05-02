import java.util.*;
class Solution {
    private static int[] apeach;
    private static int[] answer;
    private static int max;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        //모든 조합을 알아야하는 문제..
        backTracking(n,0,new int[11]);
        return max == 0 ? new int[] {-1} : answer;
    }
    
    // 어피치와 라이언의 과녁점수의 차이를 라이언 기준 구하는
    private static int getScore(int[] ryan) {
        int score = 0;
        for(int i=0; i<=10; i++) {
            if(apeach[i] + ryan[i] > 0) {
                if(ryan[i] > apeach[i]) {
                    score += (10-i);
                } else {
                    score += -(10-i);
                }
            }
        }
        return score;
    }
    
    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if(max < score) {
            max = score;
            answer = ryan.clone(); // answer 에 복사를 한다.
        } else if((max > 0) && max == score) {
            for(int i=10; i>=0; i--) {
                if(answer[i] != ryan[i]) {
                    if(answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    
    private static void backTracking(int n,int index, int[] ryan) {
        //남은 화살이 없으면
        if (n==0) {
            calculateDiff(ryan);
            return;
        }
        
        for(int i = index; i <= 10; i++){
            int cnt = Math.min(n,apeach[i] + 1);
            ryan[i] = cnt;
            backTracking(n-cnt, i+1, ryan);
            ryan[i] = 0;
        }
    }
} 