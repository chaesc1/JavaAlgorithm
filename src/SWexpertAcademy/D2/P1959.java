package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            int[] B = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 만약 n > m 이면 A,B 배열을 바꿔 줘야 한다.
            if (n > m) {
                // 배열 바꿔주고
                int[] temp = A;
                A = B;
                B = temp;
                // n,m 도 서로 바꿔준다.
                int temp2 = n;
                n = m;
                m = temp2;
            }

            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i <= m - n; i++) {
                int tempSum = 0;
                for (int j = 0; j < n; j++) {
                    tempSum += A[j] * B[j + i];
                }
                maxNum = Math.max(maxNum, tempSum);
            }
            System.out.println("#" + t + " " + maxNum);
        }


    }
}
