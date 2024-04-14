package Book;

import java.util.ArrayDeque;

public class prob15 {
    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int solution(int N, int K) {
        //ArrayDeque 에 1~5 add
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                deque.addLast(deque.pollFirst()); //k-1 번째 까지 뽑아서 뒤에 다시 넣어
            }
            deque.pollFirst(); //k 번째
        }

        return deque.pollFirst();
    }
}
