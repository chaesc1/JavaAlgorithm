package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4408 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 돌아가야 할 학생
            int count = 0;
            int[] corridor = new int[201];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = (Integer.parseInt(st.nextToken())+1)/2;// 출발
                int dest = (Integer.parseInt(st.nextToken()))/2;// 도착
                System.out.println(start+" "+dest);

                if (start < dest) {
                    for (int j = start; j <= dest; j++) {
                        corridor[j]++;
                    }
                } else {
                    for (int j = dest; j <= start; j++) {
                        corridor[j]++;
                    }
                }
            }

            Arrays.sort(corridor);
            count = corridor[200];
            sb.append("#"+t+" "+count+"\n");
        }
        System.out.println(sb);
    }
}
