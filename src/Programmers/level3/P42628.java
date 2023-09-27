package Programmers.level3;
//이중우선순위큐
//I 숫자	- 큐에 주어진 숫자를 삽입합니다.
//D 1	- 큐에서 최댓값을 삭제합니다.
//D -1	- 큐에서 최솟값을 삭제합니다.
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution42682 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String command = st.nextToken(); //명령어에서 문자부분
            int num = Integer.parseInt(st.nextToken());//명령어에서 숫자 부분

            switch (command) {
                case "I":
                    min.offer(num);
                    max.offer(num);
                    break;
                case "D":
                    //비어있는 경우
                    if (max.isEmpty()) break;
                    if (num == 1) {
                        //큐에서 최댓값 삭제
                        int maxNum = max.poll();
                        min.remove(maxNum);
                    }
                    if (num == -1) {
                        //큐에서 최솟값 삭제
                        int minNum = min.poll();
                        max.remove(minNum);
                    }
            }
        }
        if (max.isEmpty()) {
            return new int[] {0,0};
        }
        return new int[] {max.peek(),min.peek()};
    }
}
public class P42628 {
    public static void main(String[] args) {
        Solution42682 s = new Solution42682();
        int[] answer = new int[2];
        String[] oper = { "I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1" };
        answer = s.solution(oper);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
