package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // 원본배열
        int[] sorted = new int[N]; //정렬된 배열

        HashMap<Integer,Integer> map = new HashMap<>(); // 랭킹 넣을
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num =  Integer.parseInt(st.nextToken());
            arr[i] = num;
            sorted[i] = num;
        }
        Arrays.sort(sorted);

        int rank = 0;
        for(int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i,rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (map.containsKey(i)){
                sb.append(map.get(i)+" ");
            }
        }
        System.out.print(sb);
    }
}
