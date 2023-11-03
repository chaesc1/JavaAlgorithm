package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1206 {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int height = Integer.parseInt(st.nextToken());
                arr[i] = height;
            }

            int count = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                if (arr[i] > max) {
                    count += (arr[i] - max);
                }
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
