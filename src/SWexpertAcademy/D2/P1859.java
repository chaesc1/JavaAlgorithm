package SWexpertAcademy.D2;
//백만장자 만들기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3
//3
//10 7 6
//3
//3 5 9
//5
//1 1 3 1 2
public class P1859 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            long diff = 0;
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = n-1; j >= 0 ; j--) {
                if(arr[j] > max) max = arr[j];
                diff += (max - arr[j]);
            }
            System.out.printf("#%d %d\n",i+1,diff);
        }
    }
}
