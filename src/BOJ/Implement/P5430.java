package BOJ.Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            String func = br.readLine(); //명령어
            int n = Integer.parseInt(br.readLine()); // 배열 길이.

            st = new StringTokenizer(br.readLine(),"[],");
            deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken())); //deque 에 삽입
            }

            System.out.println(AC(deque,func));
        }
    }

    private static String AC(ArrayDeque<Integer> deque, String func) {
        boolean isReverse = false;
        for (char cmd : func.toCharArray()) {
            if (cmd == 'R'){    //방향 바꿔줘
                isReverse = !isReverse;
            }
            else {
                if (deque.size() == 0) {
                    return "error";
                }

                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            if (isReverse) {
                sb.append(deque.removeLast());
            } else {
                sb.append(deque.removeFirst());
            }

            if (deque.size() != 0) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
