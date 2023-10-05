package Programmers.level3;


class Solution42898 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] street =  new int[n][m];

        for(int[] puddle : puddles){
            street[puddle[0]-1][puddle[1]-1] = -1; // 연못의 위치를 -1 로
        }
        street[0][0] = 1; // 시작점 1

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(street[i][j] == -1){
                    street[i][j] = 0;
                    continue;
                }
                if(i != 0){
                    street[i][j] += street[i-1][j];
                }
                if(j != 0){
                    street[i][j] += street[i][j-1];
                }
            }
        }
        return street[n-1][m-1] % 1000000007;
    }
}
public class P42898 {
    public static void main(String[] args) {
        Solution42898 sol = new Solution42898();
        int m = 4,n = 3;
        int[][] puddles =  {{2,2}}; // 연못의 좌표 (2,2)
        int ans = sol.solution(m,n,puddles);
        System.out.println(ans);
    }
}
