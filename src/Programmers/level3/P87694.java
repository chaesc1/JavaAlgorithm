package Programmers.level3;
//레벨3 아이템 줍기

//지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle,
// 초기 캐릭터의 위치 characterX, characterY,
// 아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때,

// 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.
class SolutionP87694{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];


        return answer;
    }
}
public class P87694 {
    public static void main(String[] args) {
        SolutionP87694 sol = new SolutionP87694();
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(sol.solution(rectangle,characterX,characterY,itemX,itemY));
    }
}
