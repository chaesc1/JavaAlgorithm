package BOJ.recursive;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4779 {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) { // 압력이 없을때 까지?
            n = Integer.parseInt(str);
            int cnt = (int) Math.pow(3,n);
            sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append("-");
            }
            solve(0,cnt);
            System.out.println(sb);
        }
    }

    private static void solve(int start, int cnt) {
        if (cnt == 1) {
            return;
        }
        int size = cnt / 3;
        //3등분해서 중간 부분 공백처리를 해야해
        for (int i = start + size; i < start + 2 * size; i++) {
            sb.setCharAt(i,' ');
        }

        solve(start,size);
        solve(start+2*size,size);
    }
}
