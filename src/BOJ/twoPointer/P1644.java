package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1644 {
    static ArrayList<Integer> list;
    static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 소수 전환
        getPrime(N);

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum > N) {
                sum -= list.get(start);
                start++;
            } else if (list.size() == end) {
                break;
            }
            else {
                sum += list.get(end);
                end++;
            }
            if (N == sum) {
                count++;
            }
        }

        System.out.println(count);
    }

    //에라토스테네스의 체
    private static void getPrime(int n) {
        prime = new boolean[n+1];
        list = new ArrayList<>();
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!prime[i]) list.add(i);
        }
    }
}
