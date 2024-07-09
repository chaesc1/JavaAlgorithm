package SWexpertAcademy.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1961 {
    static int length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            length = Integer.parseInt(br.readLine());
            int[][] arr = new int[length][length];

            for (int i = 0; i < length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 90 도
            int[][] rotate90 = rotate(arr);
            // 180 도
            int[][] rotate180 = rotate(rotate90);
            // 270 도
            int[][] rotate270 = rotate(rotate180);

            System.out.println("#" + t);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(rotate90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < length; j++) {
                    System.out.print(rotate180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < length; j++) {
                    System.out.print(rotate270[i][j]);
                }
                System.out.println();
            }
        }

    }

    private static int[][] rotate(int[][] arr) {
        int[][] result = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[j][length - 1 - i] = arr[i][j];
            }
        }
        return result;
    }
}
