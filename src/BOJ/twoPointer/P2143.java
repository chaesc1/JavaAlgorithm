package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            A[i] += A[i - 1];
        }

        for (int i = 1; i < m; i++) {
            B[i] += B[i - 1];
        }

        int sizeA = n * (n + 1) / 2;
        int sizeB = m * (m + 1) / 2;
        long[] sumA = new long[sizeA];
        long[] sumB = new long[sizeB];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int value = A[j];
                if (i > 0) {
                    value -= A[i - 1];
                }
                sumA[index++] = value;
            }
        }

        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int value = B[j];
                if (i > 0) {
                    value -= B[i - 1];
                }
                sumB[index++] = value;
            }
        }
        Arrays.sort(sumA); // 1 1 2 3 3 4 4 5 6 7
        Arrays.sort(sumB); // 1 2 3 4 5 6


        //two pointer 구현
        int start = 0;
        int end = sizeB - 1;
        long answer = 0;

        while (start < sizeA && end > -1) {
            long a = sumA[start];
            long b = sumB[end];
            long sum = a + b;

            if (sum == t) {
                long aCount = 0;
                long bCount = 0;
                while (start < sizeA && a == sumA[start]) {
                    start++;
                    aCount++;
                }
                while (end > -1 && b == sumB[end]) {
                    end--;
                    bCount++;
                }

                answer += aCount*bCount;
            }
            if (sum > t) {
                end--;
            } else if(sum < t){
                start++;
            }
        }

        System.out.println(answer);
    }
}
