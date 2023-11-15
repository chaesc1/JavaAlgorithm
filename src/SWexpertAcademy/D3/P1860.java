package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1860 {
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            //N,M,K / N 명의 손님이 와 , M초에 K 개의 붕어빵을 만들어낸다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr); // 오는 순서대로 정렬해줘

            StringBuilder sb = new StringBuilder("#"+tc+" ");
            if (isPossible()) {
                sb.append("Possible");
            } else {
                sb.append("Impossible");
            }
            System.out.println(sb.toString());
        }
    }
    private static boolean isPossible() {
        for (int i = 0; i < arr.length; i++) {
            int fish = (arr[i] / M) * K;
            if (fish - 1 - i < 0 ) return false; // 손님이 왔을때 만든 최대 붕어 수 - 줘야하는 1개 - 이전에 받아간 사람 1개
        }
        return true;
    }
}
