package Programmers.level1;

class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++){
            //약수의 개수 구하는 method
            int num = divisor(i);
            //약수의 개수가 홀수 이면 answer - 해당 i
            if(num % 2 != 0){
                answer-=i;
            }
            //약수의 개수가 짝수면 answer + 해당 i
            else {
                answer+=i;
            }
        }
        return answer;
    }

    private int divisor(int num) {
        int cnt = 0;
        for (int j = 1; j <= num; j++) {
            if(num % j == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
public class P77884 {
    public static void main(String[] args) {
        Solution77884 sol = new Solution77884();
        System.out.println("sol.solution(13,17) = " + sol.solution(13,17));
    }
}
