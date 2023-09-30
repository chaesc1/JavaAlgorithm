package Programmers.level2;
//타겟 넘버 - 레벨 2
class Solution43165 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0); //number, target, sum, 깊이
        return answer;
    }

    public void dfs(int[] numbers, int target, int sum, int depth) {
        if(depth==numbers.length){
            if(target==sum) answer++;
        }else{
            dfs(numbers,target,sum+numbers[depth],depth+1);
            dfs(numbers,target,sum-numbers[depth],depth+1);
        }
    }
}
public class P43165 {
    public static void main(String[] args) {
        Solution43165 s = new Solution43165();
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(s.solution(numbers,target));
    }
}
