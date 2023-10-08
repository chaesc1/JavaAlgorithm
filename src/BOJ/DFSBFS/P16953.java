package BOJ.DFSBFS;
//A->B
//정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
//2를 곱한다.
//1을 수의 가장 오른쪽에 추가한다.
//A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

//입력
//첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다. -> 완전탐색으로? -> 시간초과??

//출력
//A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken()); //목표가 되는 숫자

        int cnt = 1;
        while (A!=target){
            if(target < A){
                System.out.println(-1);
                return;
            }

            if(target % 2 == 0){
                target /= 2;
            }else if(target % 10 == 1){
                target /= 10;
            }else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
