package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            arrA[i] += arrA[i - 1];
        }
        for (int i = 1; i < m; i++) {
            arrB[i] += arrB[i - 1];
        }

        int sizeA = n * (n + 1) / 2;
        int sizeB = m * (m + 1) / 2;

        long[] sumA = new long[sizeA];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int value = arrA[j];
                if (i > 0) {
                    value -= arrA[i - 1];
                }
                sumA[index++] = value;
            }
        }

        long[] sumB = new long[sizeB];
        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int value = arrB[j];
                if (i > 0) {
                    value -= arrB[i - 1];
                }
                sumB[index++] = value;
            }
        }
        Arrays.sort(sumA);
        Arrays.sort(sumB);

        //이진탐색 시작

    }
}
