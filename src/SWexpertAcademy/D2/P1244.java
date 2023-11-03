package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class P1244 {
    static int[] arr;
    static int max;
    static int change;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            //옮기는 횟수
            change = Integer.parseInt(st.nextToken());

            if (change > num.length()) {
                change = num.length();
            }

            arr = new int[num.length()];
            for (int i = 0; i < num.length(); i++) {
                arr[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
            }
            max = 0;

            dfs(0, 0, num.length()); //인덱스 , 바꾼횟수, 총 숫자길이
            System.out.println("#"+t+" "+max);
        }
    }

    private static void dfs(int idx, int count, int length) {
        if (count == change) {
            String s = "";
            for (int i : arr) {
                s += Integer.toString(i);
            }
            max = Math.max(max, Integer.parseInt(s));
            return;
        }

        for (int i = idx; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                dfs(i, count + 1, length);
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
