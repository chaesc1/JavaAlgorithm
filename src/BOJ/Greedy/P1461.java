package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // 음수는 오름차순
        Collections.sort(negative);
        // 양수는 내림차순
        Collections.sort(positive, Collections.reverseOrder());

        ArrayList<Integer> distance = new ArrayList<>();
        while (!negative.isEmpty()) {
            int dist = 0;
            dist = negative.remove(0);
            for (int i = 1; i < M; i++) {
                if (!negative.isEmpty()) {
                    negative.remove(0);
                }
            }
            distance.add(-dist);
        }

        while (!positive.isEmpty()) {
            int dist = 0;
            dist = positive.remove(0);
            for (int i = 1; i < M; i++) {
                if (!positive.isEmpty()) {
                    positive.remove(0);
                }
            }
            distance.add(dist);
        }

        int answer = 0;
        Collections.sort(distance);
        for (int i = 0; i < distance.size(); i++) {
            if (i == distance.size() - 1) {
                answer += distance.get(i);
            } else {
                answer += (distance.get(i) * 2);
            }
        }

        System.out.println(answer);
    }
}
