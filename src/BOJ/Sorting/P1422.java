package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1422 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<String> list = new ArrayList<>();
        String[] arr = new String[k];
        int max = 0;

        for (int i = 0; i < k; i++) {
            list.add(br.readLine());
//            arr[i] = br.readLine();
            max = Math.max(max,Integer.parseInt(list.get(i)));
        }

//        Arrays.sort(arr, (o1, o2) ->(o2 + o1).compareTo(o1 + o2));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

//        boolean flag = true;
        StringBuilder sb = new StringBuilder();
//        for(String s : arr){
//            sb.append(s);
//            if(max == Integer.parseInt(s) && flag){
//                for(int i=k; i<n; i++){
//                    sb.append(s);
//                    flag = false;
//                }
//            }
//        }
        boolean flag = false;
        for (String s : list){
            sb.append(s);
            if(max == Integer.parseInt(s) && !flag){
                for (int i = k; i < n; i++) {
                    sb.append(s);
                    flag = true;
                }
            }
        }

        System.out.println(sb);
    }
}
