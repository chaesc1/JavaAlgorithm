import java.util.*;
// l: 왼쪽으로 한 칸 이동
// r: 오른쪽으로 한 칸 이동
// u: 위쪽으로 한 칸 이동
// d: 아래쪽으로 한 칸 이동

class Solution {
    // d > l > r > u 순서
    static char[] dir = {'d','l','r','u'};
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        // 전체 도달 가능성 체크.
        int dist = Math.abs(x-r) + Math.abs(y-c);
        // 왔다 갔다 하는 경로 존재 => k-dist 가 홀수면 존재함 그리디하지 않음
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        int cx = x, cy = y;
        for(int step = 1; step <= k; step++) {
            for(int d=0; d<4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue; // 격자 밖
                
                int remain = k - step;
                int nextDist = Math.abs(nx - r) + Math.abs(ny - c);
                if (nextDist <= remain && (remain - nextDist) % 2 == 0) {
                    // 경로에 최소한으로 도달 가능하면
                    sb.append(dir[d]);
                    cx = nx;
                    cy = ny;
                    break;
                }
            }
        }
        return sb.toString();
    }
}