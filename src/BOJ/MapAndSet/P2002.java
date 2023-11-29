package BOJ.MapAndSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class P2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(),i);
        }

        HashMap<String,Integer> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map2.put(br.readLine(),i);
        }
        System.out.println(map);
        System.out.println(map2);
        int cnt = 0;

        for (int start : map.values()) {
            for (int end : map.values()) {
                if (start > end) {
                    cnt++;
                    break;
                }
            }
        }

//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            String s = br.readLine();
//            arr[i] = map.get(s);
//        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        int cnt = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = i+1; j < N; j++) {
//                if (arr[i] > arr[j]) {
//                    cnt++;
//                    break;
//                }
//            }
//        }
        System.out.println(cnt-1);
    }
}
