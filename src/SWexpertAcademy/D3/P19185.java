package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P19185 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] first = new String[N];
            String[] last = new String[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                first[j] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                last[j] = st.nextToken();
            }

            StringBuilder sb = new StringBuilder();
            int Q = Integer.parseInt(br.readLine());
            sb.append("#" + i + " ");
            for (int j = 0; j < Q; j++) {
                int num = Integer.parseInt(br.readLine());

                sb.append(first[(num-1) % first.length] + last[(num-1) % last.length] + " ");
            }
            sb.append("\n");
            System.out.println(sb.toString().trim());
        }


    }
}
