import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            // 입력 파싱
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String input = br.readLine();

            // 한 변에 있는 숫자 개수 (한 변의 길이)
            int length = N / 4;

            // 최대 상위 K개의 고유 숫자를 저장할 우선순위 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // 모든 가능한 회전된 상태의 숫자를 넣기
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 4; j++) {
                    String num = input.substring(j * length, (j + 1) * length);
                    pq.offer(Integer.parseInt(num, 16));
                }
                // 문자열 회전
                input = input.substring(1) + input.charAt(0);
            }

            // 고유 숫자 세트 사용
            Set<Integer> uniqueNums = new HashSet<>(pq);

            // 우선순위 큐 다시 초기화
            pq.clear();
            pq.addAll(uniqueNums);

            // K번째 큰 값 꺼내기
            int result = 0;
            for (int i = 0; i < K; i++) {
                result = pq.poll();
            }

            // 결과 기록
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}