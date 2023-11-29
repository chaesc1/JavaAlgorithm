package BOJ.MapAndSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String,Integer> map = new HashMap<>(); //key 의상 종류 ,
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type,map.getOrDefault(type,0)+1);
            }

            int result = 1;
            for(int count : map.values()) {
                result *= (count+1);
            }
            System.out.println(result-1);

        }
    }
}
