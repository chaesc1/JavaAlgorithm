package Programmers.level3;


import java.util.Arrays;

class SolutionP42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->{
            return o1[1] - o2[1];
        });
//        for (int i = 0; i < routes.length; i++) {
//            for (int j = 0; j < routes[i].length; j++) {
//                System.out.print(routes[i][j]);
//            }
//            System.out.println();
//        }

        int cam = Integer.MIN_VALUE;
        //현재 차량의 진출시간 > 다음 차량의 진입시간 --> 카메라 한대 추가
        for (int i = 0; i < routes.length; i++) {
            if(routes[i][0] > cam){
                cam = routes[i][1]; //진출시간에 카메라를 설치하고
                answer++;
            }
        }
        return answer;
    }
}
public class P42884 {
    public static void main(String[] args) {
        SolutionP42884 sol = new SolutionP42884();
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        //sol.solution(routes);
        System.out.println(sol.solution(routes));
    }
}
