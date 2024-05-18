import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int result = 0;
            int[] arr = new int[N]; // 주식 가격 저장
            // 구매한 주식 정보 담을 리스트
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr[0]);
            for (int j = 1; j < N; j++) {
                // 주식 가격이 올랐다면
                if (arr[j] > list.get(list.size() - 1)) {
                    list.add(arr[j]);
                } else {
                    // 다음 구매할 주식 탐색
                    int left = 0;
                    int right = list.size() - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) < arr[j]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    list.set(left,arr[j]);
                }
            }
            if (list.size() >= K) {
                result = 1;
            }
            System.out.println("Case #"+i);
            System.out.println(result);
        }

    }
}
