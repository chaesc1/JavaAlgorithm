package SWexpertAcademy.CodeBattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testcase; tc++) {
            //수열의 길이 N, 추가 횟수 M, 출력할 인덱스 번호 L
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    list.add(index, num);
                } else if (command.equals("D")) {
                    int index = Integer.parseInt(st.nextToken());
                    list.remove(index);
                } else if (command.equals("C")) {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    list.set(index, num);
                }
            }
            //6<=L<=N+M
            if (list.size() > L) {
                System.out.println("#" + tc + " " + list.get(L));
            } else {
                System.out.println("#" + tc + " " + -1);
            }
        }
    }
}
