class Solution {
    private static boolean[] visited;
    private static int[][] computer;
    
     private static void dfs(int now) {
        visited[now] = true;
        for(int i=0; i<computer[now].length; i++) {
            if(computer[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }    
        }
        return answer;
    }
}