package BOJ.Implement;
//집합 실버 5


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
//비트 마스킹????????????????!?!?!?!?!?
//add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//all: S를 {1, 2, ..., 20} 으로 바꾼다.
//empty: S를 공집합으로 바꾼다.
public class P11723 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

        }
    }
}
