import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
            // 한 변에 있는 숫자개수
            int length = N / 4;

            HashSet<String> uniqueNum = new HashSet<>();
            // 숫자 배열을 회전시키면서 모든 숫자 세트 만듦
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 4; j++) {
                    String num = input.substring(j * length, (j + 1) * length);
                    uniqueNum.add(num);
                }
                input = input.substring(1) + input.charAt(0);
            }

            List<String> sortedNum = new ArrayList<>(uniqueNum);

            Collections.sort(sortedNum, (a, b) -> {
                int aInt = Integer.parseInt(a, 16);
                int bInt = Integer.parseInt(b, 16);
                return Integer.compare(bInt, aInt);
            });

            int result = Integer.parseInt(sortedNum.get(K - 1), 16);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());

    }
}