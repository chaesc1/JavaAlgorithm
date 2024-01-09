package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//첫째 줄에 집의 위치 X Y와 걸어서 한 블록 가는데 걸리는 시간 W와 대각선으로 한 블록을 가로지르는 시간 S가 주어진다
public class P1459 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long sum1,sum2,sum3;

        sum1 = (x+y) * w; // 경우1

        sum2 = 0;
        if((x+y) % 2 == 0) {
            sum2 = Math.max(x,y) * s;
        } else {
            sum2 = (Math.max(x,y) - 1) * s + w;
        }
        
        sum3 = (Math.min(x,y) * s) + (Math.abs(x-y) * w);
        
        long answer = Math.min(sum1,Math.min(sum2,sum3));

        System.out.println(answer);
    }
}
