package Programmers.level2;
//프로세스 스택/큐

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution42587 {
    public int solution(int[] priorities, int location){
        int answer = 0;
        //오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); 
        for(int p:priorities){
            pq.offer(p);
        }
//        System.out.println("pq = " + pq);

        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
//                System.out.println("pq = " + pq);
                if(priorities[i] == pq.peek()) {
//                    System.out.println("pq2 = " + pq);
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
public class P42587 {
    public static void main(String[] args) {
        Solution42587 sol = new Solution42587();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int loc =0;
        System.out.println(sol.solution(priorities,loc));
    }
}
