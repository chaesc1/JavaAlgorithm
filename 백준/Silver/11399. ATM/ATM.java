import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer  st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        list.sort(Comparator.naturalOrder());

        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
            total += sum;
        }
        System.out.println(total);
    }
}
