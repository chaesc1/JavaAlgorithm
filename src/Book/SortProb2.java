package Book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortProb2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        int[] merged = new int[arr1.length + arr2.length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0; // arr1 index
        int j = 0; // arr2 index
        int k = 0; // merged index

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // 남은 원소 있으면 추가
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        for (int i1 : merged) {
            System.out.print(i1 + " ");
        }
    }
}
