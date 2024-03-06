import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String ans = "123456780";
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String init = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init, 0); // 문자와 , 이동 횟수 카운트 map 에 저장
        System.out.println(bfs(init));
    }

    public static int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        q.add(init);

        while (!q.isEmpty()) {
            String pos = q.poll();
            int moveCnt = map.get(pos);
            int zeroIdx = pos.indexOf("0"); //0 의 위치 찾아

            int curX = zeroIdx % 3;
            int curY = zeroIdx / 3;

            if (pos.equals(ans)) {
                return moveCnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx > 2 || ny < 0 || ny > 2) {
                    continue;
                }
                int move = ny * 3 + nx;
                char ch = pos.charAt(move);
                //swap
                String next = pos.replace(ch,'t');
                next = next.replace('0',ch);
                next = next.replace('t','0');

                if (!map.containsKey(next)) {
                    q.add(next);
                    map.put(next,moveCnt+1);
                }
            }
        }
        return -1;
    }
}
