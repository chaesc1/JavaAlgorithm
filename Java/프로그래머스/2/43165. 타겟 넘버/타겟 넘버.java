class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0); //배열 ,목표숫자, 깊이, sum
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer++;                
            }
        } else {
            dfs(numbers,target,depth+1,sum + numbers[depth]); //덧셈
            dfs(numbers,target,depth+1,sum - numbers[depth]); //뺄셈
        }
    }
}