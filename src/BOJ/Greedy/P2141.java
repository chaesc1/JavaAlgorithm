package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P2141 {
    //각 사람들까지의 거리의 합이 최소가 되는 위치에 우체국을 세우기로 결정
    // 각 마을까지의 거리의 합이 아니라, 각 사람까지의 거리의 합임에 유의한다

    static class House implements Comparable<House> {
        long pos;
        long people;

        public House(long pos, long people) {
            this.pos = pos;
            this.people = people;
        }

        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<House> list = new ArrayList<>();

        long sum = 0;// 총인원수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long num = Long.parseLong(st.nextToken());

            list.add(new House(pos, num));
            sum += num;
        }
        // 마을 위치를 기준으로 정렬 한다.
        Collections.sort(list);

        long result = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result += list.get(i).people;
            if ((sum+1)/2 <= result) {
                sb.append(list.get(i).pos);
                break;
            }
        }

        System.out.println(sb);
    }
}
