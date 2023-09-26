package Programmers.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P02 {
    public static void main(String[] args) {
        int n = 4;
        long left = 7,right = 14;
        int len = (int)right - (int)left; //2 3 4 5 -> 4개
        int[] arr = new int[len + 1];
        int[][] arr2 = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = Math.max(i,j)+1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            int row = (int)((i+left)/n) + 1;
            int col = (int)((i+left)%n) + 1;
            arr[i] = Math.max(row,col);

            System.out.println(arr[i]);
        }
    }
}
