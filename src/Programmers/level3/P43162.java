package Programmers.level3;
//1 1 0
//1 1 0
//0 0 1

//1 1 0
//1 1 1
//0 1 1

class Solution43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!check[i]){
                dfs(i,check,computers);//start,check,computers
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int i, boolean[] check, int[][] computers) {
        check[i] = true;//시작점 check를 true로
        for (int j = 0; j < computers.length; j++) {
            if(computers[i][j] == 1 && !check[j]){
                dfs(j,check,computers);
            }
        }
    }
}
public class P43162 {
    public static void main(String[] args) {
        Solution43162 s =  new Solution43162();
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println( s.solution(n,computers));
    }
}

