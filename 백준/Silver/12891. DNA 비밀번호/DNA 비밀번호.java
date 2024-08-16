import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int S, P;
    private static int minA, minC, minG, minT;
    private static int cntA, cntC, cntG, cntT;
    private static char[] dna;

    private static int answer;

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

    // 초기 윈도우 및 슬라이딩 윈도우 알고리즘을 수행하는 함수
    private static void solve() {
        // 초기 윈도우 처리
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }

        // 초기 윈도우 검증
        isValid();

        // 슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            // 이전 윈도우의 첫 문자를 제거하고 새로운 문자를 추가
            remove(dna[i - P]);
            add(dna[i]);
            isValid();
        }
    }

    // 특정 문자를 추가하여 카운트를 증가시키는 함수
    private static void add(char c) {
        switch (c) {
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

    // 특정 문자를 제거하여 카운트를 감소시키는 함수
    private static void remove(char c) {
        switch (c) {
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
    }

    // 현재 윈도우가 유효한지 체크하는 함수
    private static void isValid() {
        if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT) {
            answer++;
        }
    }
}