package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    //각 자릿수의 합이 큰걸 먼저 오게 한다.
                    int sum1 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) <= '9' && o1.charAt(i)>='0'){
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }
                    int sum2 = 0;
                    for (int i = 0; i < o2.length(); i++) {
                        if(o2.charAt(i) <= '9' && o2.charAt(i)>='0'){
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    if(sum1 == sum2){
                        //비교할수 없다면? 사전순 정렬
                        return o2.compareTo(o1);
                    }
                    else{
                        return sum1 - sum2;
                    }
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
