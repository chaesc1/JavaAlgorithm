import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d+1]; // 초밥 가짓수
        int count = 0;

        for (int i = 0; i < k; i++) {
            // 먹지 않은 초밥이면?
            if (visited[arr[i]] == 0) {
                count++;
            }
            visited[arr[i]]++; // 먹은거 표시함
        }

        int max = count;
        if (visited[c] == 0) {
            max++; // 쿠폰번호 초밥 안먹었으면?
        }

        // 이제 슬라이딩 윈도우로 접근
        for (int i = 0; i < N; i++) {
            if (max <= count) {
                if (visited[c] == 0) {
                    max = count + 1;
                } else {
                    max = count;
                }
            }
            // 좌츨 초밥 안먹은 표시하고
            visited[arr[i]]--;
            if (visited[arr[i]] == 0) {
                count--;
            }

            if (visited[arr[(i + k) % N]] == 0) {
                count++;
            }
            visited[arr[(i + k) % N]]++;

        }
        System.out.println(max);
    }
}
