package BOJ.MapAndSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10815 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine()); // 카드 개수



        StringTokenizer st = new StringTokenizer(br.readLine());;
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(),0);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(map.get(st.nextToken()) != null) {
                sb.append("1 ");
            }else {
                sb.append("0 ");
            }
        }
        System.out.print(sb);
    }
}
