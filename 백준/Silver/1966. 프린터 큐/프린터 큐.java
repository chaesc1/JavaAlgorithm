import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            // M 번째 놓여있는 문서가 몇번째 인쇄되는지
            sb.append(solution(M)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int solution(int m) {
        int find = 0;

        while (!queue.isEmpty()) {
            int[] first = queue.poll();

            boolean isMax = true;
            // 출력 중요도를 비교해서 가장 큰 중요도를 찾아야함
            for (int i = 0; i < queue.size(); i++) {
                // 지금 뽑은 중요가 큐에 있는 중요도 보다 작다면
                if (first[1] < queue.get(i)[1]) {

                    queue.offer(first);
                    for (int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }

                    isMax = false;
                    break;
                }
            }

            if (!isMax) {
                continue;
            }

            find++;
            if (first[0] == m) {
                break;
            }
        }

        return find;
    }
}
