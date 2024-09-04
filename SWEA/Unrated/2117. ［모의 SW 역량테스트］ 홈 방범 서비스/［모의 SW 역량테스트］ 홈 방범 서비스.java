import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class House {
        int x, y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int max;
    static int[][] map;
    static ArrayList<House> houseArrayList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            houseArrayList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        houseArrayList.add(new House(i, j));
                    }
                }
            }

            int k = 0;
            if (k % 2 == 0) {
                k = N + 1;
            } else {
                k = N;
            }

            max = Integer.MIN_VALUE;
            for (int i = k; i >= 1; i--) {
                if (getOperation(i) <= max) break;

                for (int j = 0; j < N; j++) {
                    for (int l = 0; l < N; l++) {
                        // x,y 좌표를 중심으로 k + - 만큼
                        solve(j, l, i);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve(int x, int y, int k) {
        int houseCount = 0;
        for (House house : houseArrayList) {
            int dist = Math.abs(x - house.x) + Math.abs(y - house.y);
            if (dist < k) {
                houseCount++;
            }
        }
        int cost = (houseCount * M) - getOperation(k);
        if (cost >= 0) {
            max = Math.max(max, houseCount);
        }
    }

    // 운영 비용 = K * K + (K - 1) * (K - 1)
    private static int getOperation(int k) {
        return k * k + (k - 1) * (k - 1);
    }
}