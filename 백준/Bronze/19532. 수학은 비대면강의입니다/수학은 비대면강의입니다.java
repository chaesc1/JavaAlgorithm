//브론즈 2
//수학은 비대면 강의입니다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //ax + by = c
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        //dx + ey = f
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int num_y = (b * d) - (e * a);
        int y = (c*d) - (f*a);
        int x = f - (e *(y/num_y));
        StringBuilder sb = new StringBuilder();
        sb.append(x/d).append(" ");
        sb.append(y/num_y);
        System.out.println(sb);
    }
}
