package Programmers.level2;

class Solution49994 {
    //U -> D -> L -> R 순서
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][] visited = new boolean[11][11][4];
        // 갔다가 돌아오는 경우도 중복 체크를 해줘야하니까
        int startX = 5;
        int startY = 5;
        for (int i = 0; i < dirs.length(); i++) {
            int direction = 0;
            if(dirs.charAt(i) == 'U'){
                direction = 0;
            }
            if(dirs.charAt(i) == 'D'){
                direction = 1;
            }
            if(dirs.charAt(i) == 'L'){
                direction = 2;
            }
            if(dirs.charAt(i) == 'R'){
                direction = 3;
            }
            int nextX = startX + dx[direction];
            int nextY = startY + dy[direction];
            //map 밖이면 ?
            if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10)
                continue;
            if(!visited[nextX][nextY][direction]){
                visited[nextX][nextY][direction] = true;
                if(direction == 0) {
                    direction = 1;
                    visited[startX][startY][direction] = true; // 반대 방향도 true 로
                }
                else if(direction == 1) {
                    direction = 0;
                    visited[startX][startY][direction] = true; // 반대 방향도 true 로
                }
                else if(direction == 2) {
                    direction = 3;
                    visited[startX][startY][direction] = true; // 반대 방향도 true 로
                }
                else if(direction == 3) {
                    direction = 2;
                    visited[startX][startY][direction] = true; // 반대 방향도 true 로
                }

                answer++;
            }
            startX = nextX;
            startY = nextY;
        }
        return answer;
    }
}
public class P49994 {
    public static void main(String[] args) {
        Solution49994 sol = new Solution49994();
        System.out.println("sol.solution(\"ULURRDLLU\") = " + sol.solution("ULURRDLLU"));
    }
}
