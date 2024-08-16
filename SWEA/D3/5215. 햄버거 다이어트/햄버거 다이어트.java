import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    // 재료의 점수와 칼로리를 담는 클래스
    static class Info {
        int score;
        int cal;

        // 생성자를 통해 재료의 점수와 칼로리를 초기화
        public Info(int score, int cal) {
            this.cal = cal;
            this.score = score;
        }
    }

    static int N;  // 재료의 개수
    static int L;  // 최대 허용 칼로리
    static int MAX;  // 최대 점수
    static ArrayList<Info> list;  // 재료 목록
    static boolean[] isSelected;  // 재료 선택 여부
    static StringBuilder sb = new StringBuilder();  // 출력 결과를 저장할 StringBuilder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());  // 테스트 케이스 수 입력받기

        for (int tc = 1; tc <= testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 재료의 수 입력
            L = Integer.parseInt(st.nextToken());  // 최대 허용 칼로리 입력

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());  // 재료의 점수 입력
                int c = Integer.parseInt(st.nextToken());  // 재료의 칼로리 입력
                list.add(new Info(s, c));  // 재료를 리스트에 추가
            }

            isSelected = new boolean[N];  // 재료 선택 여부 배열 초기화
            MAX = Integer.MIN_VALUE;  // 최대 점수를 매우 작은 값으로 초기화
            calcMax(0);  // 깊이를 0으로 시작하여 최대 점수 계산
            sb.append("#").append(tc).append(" ").append(MAX).append("\n");  // 출력 결과 저장
        }
        System.out.println(sb.toString());  // 최종 결과 출력
    }

    // 점수와 칼로리의 조합을 찾기 위한 재귀 함수
    private static void calcMax(int depth) {
        if (depth == N) {  // 모든 재료를 다 고려한 경우
            int score = 0;
            int cal = 0;
            // 선택된 재료의 점수와 칼로리를 계산
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    score += list.get(i).score;
                    cal += list.get(i).cal;
                }
            }
            if (cal <= L) {  // 최대 허용 칼로리를 초과하지 않는 경우
                MAX = Math.max(MAX, score);  // 최대 점수를 갱신
            }
            return;
        }
        // 현재 재료를 선택하는 경우
        isSelected[depth] = true;
        calcMax(depth + 1);
        // 현재 재료를 선택하지 않는 경우
        isSelected[depth] = false;
        calcMax(depth + 1);
    }
}