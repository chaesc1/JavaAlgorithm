import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    //자르는 횟수가 담긴 목록의 길이 N과 자를 수 있는 지점의 개수 M, 그리고 롤 케이크의 길이인 정수 L
    static int n, m, l;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[m + 1];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr[m] = l; //최종길이를 저장

        // 각 수만큼 조각을 만들었을 때 가장 작은 조각의 길이의 최댓값
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(br.readLine()); // 잘라야하는 횟수
            int left = 0;
            int right = l;
            int answer = 0;

            while (left < right) {
                int count = 0; // 자른횟수
                int mid = (left + right) / 2;
                int prev = 0;
                for (int j = 0; j <= m; j++) {
                    if (arr[j] - prev >= mid) {
                        count++;
                        prev = arr[j];
                    }
                }
                if (count <= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                    answer = Math.max(answer,mid);
                }
            }
            System.out.println(answer);
        }
    }
}