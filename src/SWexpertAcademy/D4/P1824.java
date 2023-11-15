package SWexpertAcademy.D4;
//문자	수행 명령
//<	이동 방향을 왼쪽으로 바꾼다.
//>	이동 방향을 오른쪽으로 바꾼다.
//^	이동 방향을 위쪽으로 바꾼다.
//v	이동 방향을 아래쪽으로 바꾼다.
//_	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
//|	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
//?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
//.	아무 것도 하지 않는다.
//@	프로그램의 실행을 정지한다.
//0~9	메모리에 문자가 나타내는 값을 저장한다.
//+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
//-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1824 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                }
            }
        }
    }
}
