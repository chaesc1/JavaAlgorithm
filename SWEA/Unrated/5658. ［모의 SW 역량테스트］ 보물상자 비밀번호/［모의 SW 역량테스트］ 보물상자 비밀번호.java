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
            // 한 변에 있는 숫자 개수
            int length = N / 4;

            TreeSet<String> uniqueNum = new TreeSet<>((a, b) -> {
                int aInt = Integer.parseInt(a, 16);
                int bInt = Integer.parseInt(b, 16);
                return Integer.compare(bInt, aInt);
            });

            // 모든 가능한 회전된 상태의 숫자를 관리
            char[] chars = input.toCharArray();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sbNum = new StringBuilder();
                    for (int k = 0; k < length; k++) {
                        sbNum.append(chars[(j * length + k) % N]);
                    }
                    uniqueNum.add(sbNum.toString());
                }
                rotateArray(chars);
            }

            // TreeSet의 K번째 값을 찾음
            int count = 0;
            int result = 0;
            for (String num : uniqueNum) {
                if (++count == K) {
                    result = Integer.parseInt(num, 16);
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void rotateArray(char[] arr) {
        char first = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = first;
    }
}