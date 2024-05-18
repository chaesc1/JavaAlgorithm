package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
    static int L;
    static int C;
    static char[] list;
    static boolean[] visited;
    static char[] password;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        // 문자리스트 정렬하고
        Arrays.sort(list);
        // 백트랙킹으로 모든 조합을
        // 최소 하나의 모음 , 두개 이상의 자음이 있는지 판단
        // 그리고 저장
        backtrack(0, 0);

    }

    private static void backtrack(int start, int idx) {
        if (idx == L) {
            //하나의 모음, 두개 이상의 자음이 있는지 판단
            String password = "";
            int mo = 0;
            int ja = 0;

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    password += list[i];

                    if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] =='o' || list[i] =='u') {
                        mo++;
                    } else {
                        ja++;
                    }
                }
            }
            if (mo >= 1 && ja >= 2) {
                System.out.println(password);
            }
        }

        for (int i = start; i < C; i++) {
            visited[i] = true;
            backtrack(i + 1, idx + 1);
            visited[i] = false;
        }
    }
}
