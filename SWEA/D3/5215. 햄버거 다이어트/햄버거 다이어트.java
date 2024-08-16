import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Info {
        int score;
        int cal;

        public Info(int score, int cal) {
            this.cal = cal;
            this.score = score;
        }
    }

    static int N;
    static int L;
    static int MAX;
    static ArrayList<Info> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Info(s, c));
            }

            MAX = Integer.MIN_VALUE;
            calcMax(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(MAX).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void calcMax(int score, int cal, int depth) {
        if (depth == N) {
            if (cal > L) return;
            MAX = Math.max(MAX, score);
            return;
        }
        calcMax(score + list.get(depth).score, cal + list.get(depth).cal, depth + 1);
        calcMax(score, cal, depth + 1);
    }
}