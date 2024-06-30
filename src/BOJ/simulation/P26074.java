package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26074 {
    static int N, M;
    static int[][] map;
    static int[] scores = new int[8]; // 테트리스의 각 점수
    static int[][][] tetris = {
            {{1, 1, 1, 1}},
            {{1, 1, 1}, {1, 0, 0}},
            {{1, 1, 1}, {0, 0, 1}},
            {{1, 1}, {1, 1}},
            {{1, 1, 0}, {0, 1, 1}},
            {{1, 1, 1}, {0, 1, 0}},
            {{0, 1, 1}, {1, 1, 0}},
            {{1}}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        // 모든 맵에 다 넣어보면서 완전탐색해야해 dfs
        dfs(true);
    }
    private static double dfs(boolean isGomTurn) {
        return 0.0;
    }
}
