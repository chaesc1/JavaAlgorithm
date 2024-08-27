import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] words;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        words = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(words);

        //암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
        // 백트래킹으로 모든 가능한 조합의 수를 구한다.
        backTracking(0, 0);
    }

    private static void backTracking(int cnt, int start) {
        if (cnt == L) {
            // 최소 한개의 모음, 두개의 자음
            StringBuilder sb = new StringBuilder();
            int mo = 0;
            int ja = 0;
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(words[i]);
                    if (words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u') {
                        mo++;
                    } else {
                        ja++;
                    }
                }
            }
            if (mo >= 1 && ja >= 2) {
                System.out.println(sb);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            visited[i] = true;
            backTracking(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}