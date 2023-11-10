package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//숨바꼭질3 - gold3
// 순간이동 (*2 ) -> 0 초
// 1 앞으로 -> 1초 , 1 뒤로 -> 1초

public class P13549_queue {
    //가장 빠른 시간을 구해야해.
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bfs(N, K);
    }

    public static void bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});

        boolean[] isVisit = new boolean[100_001];
        isVisit[N] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int position = cur[0];
            int time = cur[1];

            if (position == K) {
                System.out.println(time);
                return;
            }
            int warp = position * 2;// 순간이동한 위치 가중치가 2라서 제일 먼저 해줘야해
            if (warp < 100001 && !isVisit[warp]) {
                isVisit[warp] = true;
                q.add(new int[] {warp,time}); // time = 0초라서 그대로
            }
            for (int i = 0; i < 2; i++) {
                int nx = position + dx[i];
                if(nx >= 0 && nx < 100001) {//범위 내
                    //방문하지 않았다면
                    if (!isVisit[nx]) {
                        isVisit[nx] = true;
                        q.add(new int[] {nx,time+1});
                    }
                }
            }

        }
    }
}
