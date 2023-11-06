package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1209 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            int tc = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];
            for (int j = 0; j <100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k <100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int col_sum = 0;
            int row_sum = 0;
            int diag_sum1 = 0;
            int diag_sum2 = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <100; j++) {
                col_sum = 0;
                row_sum = 0;
                diag_sum1 += arr[j][j];
                diag_sum2 += arr[j][99-j];
                for (int k = 0; k < 100; k++) {
                    col_sum += arr[j][k];
                    row_sum += arr[k][j];
                }
                max = Math.max(max,col_sum);
                max = Math.max(max,row_sum);
            }
            max = Math.max(max,diag_sum1);
            max = Math.max(max,diag_sum2);

            System.out.println("#"+i+" "+max);
        }
    }
}
