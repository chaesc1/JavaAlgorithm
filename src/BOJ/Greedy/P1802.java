package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1은 위의 그림에서 OUT을 의미하고
//0은 위의 그림에서 IN
public class P1802 {

    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            input = br.readLine();
            if (check(0, input.length() - 1)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(int start, int end) {
        if (start == end) {
            //길이가 1 인경우 true
            return true;
        }
        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            if (input.charAt(i) == input.charAt(end-i)) {
                return false;
            }
        }
        return check(start,mid-1) && check(mid+1,end);
    }
}
