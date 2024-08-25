package SWexpertAcademy.AType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5644최적화 {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dir) {
            if (dir == 1) {
                y--;
            } else if (dir == 2) {
                x++;
            } else if (dir == 3) {
                y++;
            } else if (dir == 4) {
                x--;
            }
        }
    }

    static class BC {
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        public boolean isInRange(int px, int py) {
            return Math.abs(x - px) + Math.abs(y - py) <= c;
        }
    }
    static BC[] bcs;
    static int[] dirA, dirB;
    static int m, a;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

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

            bcs = new BC[a];
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[i] = new BC(x, y, c, p);
            }

            result = 0;
            solve();

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb.toString());
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
        int maxCharge = 0;

        for (int i = 0; i < a; i++) {
            BC bcA = bcs[i];
            boolean isAInRange = bcA.isInRange(userA.x, userA.y);

            for (int j = 0; j < a; j++) {
                BC bcB = bcs[j];
                boolean isBInRangeB = bcB.isInRange(userB.x, userB.y);

                int chargeA = isAInRange ? bcA.p : 0;
                int chargeB = isBInRangeB ? bcB.p : 0;

                if (i == j && isAInRange && isBInRangeB) {
                    maxCharge = Math.max(maxCharge, chargeA / 2 + chargeB / 2);
                } else {
                    maxCharge = Math.max(maxCharge, chargeA + chargeB);
                }
            }
        }

        result += maxCharge;
    }
}