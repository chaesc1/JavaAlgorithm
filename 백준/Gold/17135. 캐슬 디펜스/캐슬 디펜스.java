import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Archor {
        int x;
        int y;

        public Archor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, D;
    static int[][] map;
    static int[][] copy;
    static int maxKill;
    static ArrayList<Archor> archorList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

        map = new int[N][M];

        //0은 빈 칸, 1은 적이 있는 칸
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 배치 -> 순서 상관 X -> 조합
        setArchor(0, 0);
        System.out.println(maxKill);
    }

    private static void setArchor(int start, int depth) {
        if (depth == 3) {
            simulate();
            return;
        }

        for (int i = start; i < M; i++) {
            archorList.add(new Archor(N, i));
            setArchor(i + 1, depth + 1);
            archorList.remove(archorList.size() - 1);
        }

    }

    private static void simulate() {
        copyMap();
        int killCount = 0;

        while (!isGameEnd()) {
            // 각 궁수가 공격할 적을 찾아서 공격
            ArrayList<int[]> targets = selectTargets();

            for (int[] target : targets) {
                if (copy[target[0]][target[1]] == 1) {
                    killCount++;
                    copy[target[0]][target[1]] = 0;
                }
            }
            // 적 이동
            moveEnemies();
        }
        maxKill = Math.max(maxKill, killCount);
    }

    //적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외
    private static void moveEnemies() {
        for (int i = N - 1; i > 0; i--) {
            System.arraycopy(copy[i-1], 0, copy[i], 0, M);
        }
        // 첫 횅은 0으로 초기화.
        for (int j = 0; j < M; j++) {
            copy[0][j] = 0;
        }
    }

    private static ArrayList<int[]> selectTargets() {
        ArrayList<int[]> targetList = new ArrayList<>();
        for (Archor archor : archorList) {
            // 궁수의 위치에서 찾을 수있는 타겟을 모두 담아.
            int[] target = findTarget(archor.x, archor.y);
            if (target != null) {
                targetList.add(target);
            }
        }
        return targetList;
    }

    private static int[] findTarget(int x, int y) {
        int minDist = Integer.MAX_VALUE;
        int[] target = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 1) {
                    int dist = Math.abs(x - i) + Math.abs(y - j);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && j < (target == null ? M : target[1]))) {
                            minDist = dist;
                            target = new int[]{i, j};
                        }
                    }
                }
            }
        }
        return target;
    }

    private static boolean isGameEnd() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 1) { // 적이 있으면
                    return false; // 아직 안끝나
                }
            }
        }
        return true; // 게임 종료
    }

    private static void copyMap() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, M);
        }
    }
}