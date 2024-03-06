import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(),i);
        }
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = map.get(s);
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
