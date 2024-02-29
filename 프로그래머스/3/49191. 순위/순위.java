class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            int start = results[i][0];
            int end = results[i][1];
            
            floyd[start][end] = 1;
            floyd[end][start] = -1;
        }
        
        
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    
                    if(floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }
        
        for(int j=1; j<=n; j++) {
            int cnt = 0;
            for(int k=1; k<=n; k++) {
                if(floyd[j][k]!= 0) cnt ++;
            }
            // System.out.println(cnt);
            if(cnt == n-1) answer++;
        }
    
        return answer;   
    }
}
//플로이드 와샬?선수의 수는 1명 이상 100명 이하입니다.
// 100 ^ 3
//4 - 3 -> 4번은 3번에게 승리
// 2 번은 1,3,4 번 선수에게 패배함 
// 2 번은 5번을 이김 
// 결국 2번 - 4등 / 5번 - 5등