package Programmers.level3;
////여행경로
//주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다.
// 항상 "ICN" 공항에서 출발합니다.
//
//항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때,
// 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution43164 {
    //들어온 문자열을 자동으로 오름차순 정렬된다.
    public Queue<String> pq = new PriorityQueue<>();
    public boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer;
        int cnt = 0;
        //방문 체크 배열
        visited = new boolean[tickets.length];

        //dfs 실행 - 첫 시작은 무조건 ICN
        dfs(tickets,"ICN","ICN",0); //티켓 , 출발지 , 전체 경로 , cnt
        answer = pq.peek().split(",");

        for (String airport : answer) {
            System.out.print(airport + " ");
        }

        return answer;
    }

    public void dfs(String[][] tickets, String start, String path, int cnt) {
        if(cnt == tickets.length){
            pq.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            //간적 없고 , 시작의 도착점이 다음 여행지의 시작점이면
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets,tickets[i][1],path + ","+tickets[i][1],cnt+1);
                visited[i] = false;
            }
        }
    }
}
public class P43164 {
    public static void main(String[] args) {
        Solution43164 s = new Solution43164();
        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        s.solution(tickets);
    }
}
