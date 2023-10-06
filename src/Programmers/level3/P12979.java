package Programmers.level3;

import java.util.PriorityQueue;

class Solution12979{
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int station_idx = 0; //설치된 기지국의 인덱스
        int cur_position = 1; //1-n동 까지

        while (cur_position <= n){
            //설치 된 기지국 index ex) 0,1 이 설치된 갯수보다 작고 / 현재 위치가 이미 설치된 기지국의 통신 범위 내부라면?
            if(station_idx < stations.length && cur_position >= stations[station_idx] - w) {
                //다음으로 이동해야할 위치
                cur_position = stations[station_idx] + w + 1;
                station_idx++; // 다음 기지국으로 인덱스를 옮겨
            }else{
                answer++;
                //좌 중간 우
                cur_position += (w*2) + 1;
            }
        }
        return answer;
    }
}
public class P12979 {
    public static void main(String[] args) {
        Solution12979 sol = new Solution12979();
        System.out.println("sol.solution = " + sol.solution(11, new int[] {4,11}, 1));
    }
}
