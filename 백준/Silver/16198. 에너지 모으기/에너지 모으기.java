import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        backTrack(list, 0);
        System.out.println(max);
    }

    private static void backTrack(ArrayList<Integer> list, int sum) {
        if (list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int tmp = list.get(i);
            int energy = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            backTrack(list, sum + energy);
            list.add(i,tmp);
        }
    }
}
