import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dir) {
            int[] dx = {0, 0, 1, 0, -1};
            int[] dy = {0, -1, 0, 1, 0};
            x += dx[dir];
            y += dy[dir];
        }
    }

    static class BC {
        Pos pos;
        int c;
        int p;

        public BC(Pos pos, int c, int p) {
            this.pos = pos;
            this.c = c;
            this.p = p;
        }
    }
    static ArrayList<BC> bcs;
    static int[] dirA;
    static int[] dirB;
    static int t;
    static int m;
    static int a;
    static int result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            bcs = new ArrayList<>();

            dirA = new int[m];
            dirB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                dirA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                dirB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs.add(new BC(new Pos(x, y), c, p));
            }
            result = 0;
            solve();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        Pos userA = new Pos(1, 1);
        Pos userB = new Pos(10, 10);

        charge(userA, userB);

        for (int i = 0; i < m; i++) {
            userA.move(dirA[i]);
            userB.move(dirB[i]);
            charge(userA, userB);
        }
    }

    private static void charge(Pos userA, Pos userB) {
        ArrayList<int[]> aList = new ArrayList<>();
        ArrayList<int[]> bList = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            BC bc = bcs.get(i);
            int distA = Math.abs(bc.pos.x - userA.x) + Math.abs(bc.pos.y - userA.y);
            int distB = Math.abs(bc.pos.x - userB.x) + Math.abs(bc.pos.y - userB.y);

            if (bc.c >= distA) {
                aList.add(new int[]{i, bc.p});
            }
            if (bc.c >= distB) {
                bList.add(new int[]{i, bc.p});
            }
        }

        int max = 0;

        if (!aList.isEmpty() && !bList.isEmpty()) {
            for (int[] bcA : aList) {
                for (int[] bcB : bList) {
                    int sum = (bcA[0] == bcB[0]) ? bcA[1] : bcA[1] + bcB[1];
                    max = Math.max(max, sum);
                }
            }
        } else if (!aList.isEmpty()) {
            max = aList.stream().mapToInt(bc -> bc[1]).max().orElse(0);
        } else if (!bList.isEmpty()) {
            max = bList.stream().mapToInt(bc -> bc[1]).max().orElse(0);
        }

        result += max;
    }
}