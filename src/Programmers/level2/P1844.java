package Programmers.level2;
//map에서 1은 길 0은 벽
class Solution1844 {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int min_cnt = -1;
    int[][] visited;//방문한 곳 check
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];

        dfs(0,0,maps,visited,1);//x,y,좌표,

        return min_cnt;
    }
    //시간초과 -> 넓이 우선 탐색을 적용해야해
    public int dfs(int x, int y, int[][] maps, int[][] visited, int cnt) {
        int rows = maps[0].length;//width
        int cols = maps.length;//height

        // 끝에 도착하면
        if(x == rows-1 && y == cols-1){
            if(min_cnt==-1){
                min_cnt = cnt;
                return 0;
            } else if (min_cnt > cnt) {
                min_cnt = cnt;
                return 0;
            }
        }
        int curX;
        int curY;
        for (int i = 0; i < 4; i++) {
            curX = x+ dx[i];
            curY = y+ dy[i];
            //map 내부면?
            if((curX >= 0 && curX < rows)&&(curY >= 0 && curY < cols)){
                //길이면 ?
                if(maps[curX][curY] == 1){
                    //방문한 곳이면?
                    if(visited[curX][curY] == 1){
                        continue;
                    }
                    visited[curX][curY] = 1;
                    dfs(curX,curY,maps,visited,cnt+1);
                    visited[curX][curY] = 0;
                }
            }
        }
        return  min_cnt;
    }
}
public class P1844 {
    public static void main(String[] args) {
        Solution1844 s = new Solution1844();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(s.solution(maps));
    }
}
