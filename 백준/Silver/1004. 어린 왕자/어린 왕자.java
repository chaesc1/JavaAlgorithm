import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //출발점 좌표 , 도착점 좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = 0;
            //행성계 개수
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if (Math.pow((x-x1),2) + Math.pow((y-y1),2) < Math.pow(r,2) && Math.pow((x-x2),2) + Math.pow((y-y2),2) > Math.pow(r,2)) {
                    answer++;
                }
                if (Math.pow((x-x1),2) + Math.pow((y-y1),2) > Math.pow(r,2) && Math.pow((x-x2),2) + Math.pow((y-y2),2) < Math.pow(r,2)) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
