import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//ACM CRAFT - GOLD 3
// 첫째 줄에 건물의 개수 N과
// 건물간의 건설순서 규칙의 총 개수 K -> 간선의 개수
public class Main {
    static int n, k;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            time = new int[n + 1]; //걸리는 시간 초기화

            ArrayList<Integer>[] list = new ArrayList[n];
            int[] indegree = new int[n + 1];
            //그래프 생성
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[j] = new ArrayList<Integer>();
                time[j] = Integer.parseInt(st.nextToken()); // 비용정보 저장
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start - 1].add(end - 1);
                indegree[end - 1]++;//들어오는 간선 개수 구해
            }
            int winNum = Integer.parseInt(br.readLine());
            System.out.println(DAG(indegree, list, winNum));
        }
    }

    private static int DAG(int[] indegree, ArrayList<Integer>[] list, int winNum) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { //시작 노드
                result[i] = time[i];
                q.offer(i);
            }
        }

        //총 소요시간 -> 이전 건물 노드 시간 누적 + 현재 건물 건설 시간
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return result[winNum - 1];
    }
}
