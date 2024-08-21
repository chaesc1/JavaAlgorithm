import java.io.BufferedReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // moo mooo moo
        // 중간 문자열은 "mo...o"이고 'o'의 개수는 k + 2
        // S(K) = S(k-1) + mo..o + S(K-1)
        // 앞 중간 뒤 로 나누어서 생각

        //basecase = moo
        long length = 3;
        int k = 0;
        while (length < N) {
            k++;
            // 처음 + 끝 + 중간
            length = 2 * length + (k + 3);
        }
        callMoo(N, k, length);
        System.out.println(sb.toString());
    }

    private static void callMoo(long n, int k, long length) {
        // Basecase : moo
        if (k == 0) {
            if (n == 1) {
                sb.append("m");
            } else {
                sb.append("o");
            }
            return;
        }

        long prevLen = (length - (k + 3)) / 2;
        if (n <= prevLen) {
            callMoo(n, k - 1, prevLen);
        } else if (n > prevLen + (k + 3)) {
            // N 번째 문자가 두번째 S(k-1) 에 포함된 경우
            callMoo(n - (prevLen + (k + 3)), k - 1, prevLen);
        } else {
            // N 번째 문자가 중간의 m..o 에 포함된 경우
            // 중간 "m" + k + 2 개의 o로 구성된 경우
            if (n - prevLen == 1) {
                sb.append("m");
            } else {
                sb.append("o");
            }
        }
    }
}