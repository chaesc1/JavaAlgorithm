import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int[][] dun; // 던전
    private static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dun = dungeons;
        visited = new boolean[dungeons.length];
        
        backTracking(k,0);
        
        return answer;
    }
    
    private static void backTracking(int k,int cnt) {
        for(int i=0; i<dun.length; i++) {
            //방문한적없고, 던전 최소 요구 피로도 <= 현재 피로도 -> 던전 입장 가능
            if(!visited[i] && dun[i][0] <= k) {
                visited[i] = true; // 방문처리
                backTracking(k-dun[i][1], cnt+1); // dfs
                answer = Math.max(answer, cnt + 1);
                visited[i] = false; 
            }
        }
    }
}