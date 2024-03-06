import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String isEnter = st.nextToken();
            if (isEnter.equals("enter")) {
                set.add(name);
            } else if (isEnter.equals("leave")) {
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }
        Collections.sort(list,Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
