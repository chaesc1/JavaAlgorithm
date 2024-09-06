import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//27,492 kb
//197 ms
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String input = br.readLine();

            int length = N / 4;

            // 모든 회전 상태의 숫자를 저장할 세트
            Set<Integer> uniqueNumSet = new HashSet<>();

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 4; j++) {
                    String num = input.substring(j * length, (j + 1) * length);
                    uniqueNumSet.add(Integer.parseInt(num, 16));
                }

                input = input.substring(N - 1) + input.substring(0, N - 1);
            }

            // 숫자를 저장한 세트를 정렬된 리스트로 변환
            List<Integer> sortedNumList = new ArrayList<>(uniqueNumSet);
            sortedNumList.sort(Collections.reverseOrder());

            // 상위 K번째 값을 얻음
            int result = sortedNumList.get(K - 1);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}