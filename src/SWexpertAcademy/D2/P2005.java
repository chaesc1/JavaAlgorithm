package SWexpertAcademy.D2;
//파스칼 삼각형

import java.util.Scanner;

public class P2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        arr[i][j] = 1;
                    } else if (j == 0) {
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    }
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
