package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1208_Re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 10;
        int[] arr = new int[100];

        StringTokenizer st;
        for (int i = 1; i <= tc; i++) {
            int dump = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken()); //배열 입력 받고 -> 정렬
            }

            for (int j = 0; j < dump; j++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.println("#"+i+" "+(arr[99]-arr[0]));
        }
    }
}
