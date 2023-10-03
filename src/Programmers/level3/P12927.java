package Programmers.level3;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

//회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
//
// 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
// Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
// 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해
// 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
class Solution12927 {
    public long solution(int n, int[] works) {
        //남은 수를 제곱해서 더하기 때문에 배열에서 가장 큰 수를 줄이는 것이 관건
        long answer = 0;
        //우선 순위 큐 기본은 오름차순 이기 때문에 Collections.reverseOrder() 이용해서 내림차순 으로 정렬
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());
        //우선 순위 큐에 works offer
        for (int i = 0; i < works.length; i++) {
            overtime.offer(works[i]);
        }
        for(int i=0; i<n; i++){
            int max = (int)overtime.poll();//poll로 우선 순위가 제일 높은(제일큰 수) 를 뽑아
            if(max <= 0) break;
            overtime.offer(max-1);
        }

        while(!overtime.isEmpty()){
            answer += Math.pow(overtime.poll(),2);
        }
        return answer;
    }
}
public class P12927 {
    public static void main(String[] args) {
        Solution12927 s = new Solution12927();
        int n = 3;
        int[] works = {1,1};
        System.out.println(s.solution(n,works));

    }
}
