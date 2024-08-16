import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S, P;
    static int minA, minC, minG, minT;
    static int cntA, cntC, cntG, cntT;
    static char[] dna;

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        minA = Integer.parseInt(st.nextToken());
        minC = Integer.parseInt(st.nextToken());
        minG = Integer.parseInt(st.nextToken());
        minT = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(answer);
        br.close();
    }

    private static void solve() {
        for (int i = 0; i < P; i++) {
            switch (dna[i]) {
                case 'A':
                    cntA++;
                    break;
                case 'C':
                    cntC++;
                    break;
                case 'G':
                    cntG++;
                    break;
                case 'T':
                    cntT++;
                    break;
            }
        }

        // min 값 이상인지 체크한번하고
        isValid();
        // 한칸씩 슬라이드해서 다시 탐색
        // 이전 값은 빼줘
        for (int i = P; i < S; i++) {
            switch (dna[i-P]) {
                case 'A':
                    cntA--;
                    break;
                case 'C':
                    cntC--;
                    break;
                case 'G':
                    cntG--;
                    break;
                case 'T':
                    cntT--;
                    break;
            }

            switch (dna[i]) {
                case 'A':
                    cntA++;
                    break;
                case 'C':
                    cntC++;
                    break;
                case 'G':
                    cntG++;
                    break;
                case 'T':
                    cntT++;
                    break;
            }
            isValid();
        }
    }

    private static void isValid() {
        if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT) {
            answer++;
        }
    }
}