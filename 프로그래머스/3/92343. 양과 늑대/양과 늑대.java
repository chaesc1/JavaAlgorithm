class Solution {
    //당신이 모은 양의 수보다 늑대의 수가 같거나 더 많아지면 바로 모든 양을 잡아먹어 버립니다
    //최대한 많은 수의 양을 모아서 다시 루트로 돌아와야해
    //들어 갔다가 다시 나와야함.
    //dfs 
    //각 노드를 방문하면서 모을 수 있는 양은 최대 몇 마리
    static boolean[] visited;
    static int maxCnt = 0; // 최대 양
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        visited = new boolean[info.length];
        dfs(visited,info,edges,0,0,0); // 방문 , info, index,edges,양 , 늑대 수
        return maxCnt;
    }
    
    private static void dfs(boolean[] visited, int[] info, int[][] edges,int index, int sheepCnt, int wolfCnt) {
        visited[index] = true;
        if(info[index] == 0) {
            //양이면
            sheepCnt++;
            if(sheepCnt > maxCnt) {
                maxCnt = sheepCnt;
            }
        } else {
            wolfCnt++;
        }
        
        if(sheepCnt <= wolfCnt) {
            return;
        }
        
        for(int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] newVisited = new boolean[info.length];
                for(int i=0; i<visited.length; i++) {
                    newVisited[i] = visited[i]; // 노드맏 ㅏ방문표시 복사
                }
                //다음 edge 부터 다시 dfs
                dfs(newVisited,info,edges,edge[1],sheepCnt, wolfCnt);
            }
        }
    }
}