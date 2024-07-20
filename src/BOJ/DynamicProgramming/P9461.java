package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9461 {
    static long[] arr = new long[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        pado();
        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(arr[N]);
        }

    }

    private static void pado() {
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
    }
}
