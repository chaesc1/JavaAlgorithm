import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }
        HashSet<String> set = new HashSet<>(arr);
        // Set을 다시 ArrayList로 변환합니다.
        ArrayList<String> uniqueArr = new ArrayList<>(set);
        
        // 배열을 정렬합니다.
        uniqueArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for(String s : uniqueArr){
            System.out.println( s);
        }
    }
}
