package SWexpertAcademy.CodeBattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = 10;

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= testcase; tc++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String command = st.nextToken();
                if (command.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.add(x+j, Integer.valueOf(st.nextToken()));
                    }
                } else if (command.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.remove(x);
                    }
                } else if (command.equals("A")) {
                    int x = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < x; j++) {
                        int num = Integer.parseInt(st.nextToken());
                        list.add(num);
                    }
                }
            }
            sb.append("#"+tc);
            for(int i =0; i<10; i++) {
                sb.append(" " + list.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
