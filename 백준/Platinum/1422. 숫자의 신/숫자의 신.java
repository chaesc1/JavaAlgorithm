import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

//        ArrayList<Integer> arr = new ArrayList<>();
        String[] arr = new String[k];
        int max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = br.readLine();
            max = Math.max(max,Integer.parseInt(arr[i]));
        }

        Arrays.sort(arr, (o1, o2) ->(o2 + o1).compareTo(o1 + o2));

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
            if(max == Integer.parseInt(s) && flag){
                for(int i=k; i<n; i++){
                    sb.append(s);
                    flag = false;
                }
            }
        }

        System.out.println(sb);
    }
}
