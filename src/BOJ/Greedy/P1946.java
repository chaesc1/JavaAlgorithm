package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1946 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            arr = new int[num][2];

            for (int j = 0; j < num; j++) {
                //서류 순위 , 면접 순위
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            //서류 순위 순으로 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
//
//            for (int[] sec : arr) {
//                System.out.println(sec[0] + " " + sec[1]);
//            }
            int cnt = 0;
            int first = arr[0][1]; //서류 1등의 면접점수
            for (int j = 1; j < arr.length; j++) {
                if (first < arr[j][1]) {
                    cnt++; //탈락자 수
                    continue;
                }
                first = arr[j][1];
            }

            System.out.println(num-cnt);
        }
    }
}
