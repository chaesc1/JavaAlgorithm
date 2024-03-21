package BOJ.Graph;

//줄세우기
//위상정렬 , 그래프이론

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //진입차수 카운트 해줘야해
        int[] entryCount = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph.get(num1).add(num2);
            entryCount[num2]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //Topology Sort start
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (entryCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int studentNum = q.poll();
            bw.write(String.valueOf(studentNum) + " ");

            ArrayList<Integer> list = graph.get(studentNum);
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                entryCount[temp]--;

                if (entryCount[temp] == 0) {
                    q.offer(temp);
                }
            }
        }

        bw.flush();
    }
}
