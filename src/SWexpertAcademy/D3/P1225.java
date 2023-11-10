package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1225 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int count = 1;
            while (true) {
                int num = q.poll() - count; // 맨앞을 빼서 1 빼고

                if (num <= 0) {
                    q.offer(0);
                    break;
                } else {
                    q.offer(num); // 맨뒤에 넣고
                }
                count++;
                if(count > 5) {
                    count = 1;
                }
            }
            System.out.println("#"+t+" ");
            for (int i = 0; i < 8; i++) {
                System.out.print(q.poll()+" ");
            }
            System.out.println();
        }
    }
}
