package SWexpertAcademy.D3;
//0 또는 1로 구성된 두 이진 수열 a1 , a2 , ···, an 과   b1, b2, ···, bm에 대해, 이 수열의 XOR 2차원배열 Fa,b 는 n X m 크기의 배열로, Fa,b  [i][j] =ai ⊕bj   로 정의된다.
// 여기서 ⊕는 bitwise XOR 연산자로, 0 ⊕ 0 = 0, 0 ⊕ 1 = 1, 1 ⊕ 0 = 1, 1 ⊕ 1 = 0이다.
//0 또는 1로 구성된 n X m 크기의 2차원 배열 T가 주어질 때, 이 배열이 어떤 이진 수열의 XOR 2차원 배열인지를 판단하는 프로그램을 작성하라.

//[입력]
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//각 테스트 케이스의 첫 번째 줄에는 배열의 크기를 나타내는 두 자연수 n과 m (1≤n, m≤5)이 공백 하나를 사이로 두고 주어진다. 다음 n개 줄에는 길이가 m인 0 또는 1로만 구성된 문자열이 주어지는데, 이 중 i번째 줄의 j번째 글자는  T[i][j]이다.
//
//[출력]
//각 테스트 케이스마다, T가 어떤 이진 수열의 XOR 2차원 배열이라면 (즉, 어떤 이진 수열 a1 , a2 , ···, an과   b1, b2, ···, bm에 대해 T=Fa,b  라면) ‘yes’를, 그렇지 않다면 ‘no’를 출력한다.
public class P15868 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = num;
                }
            }
            if(isXOR(arr)){
                System.out.println("#"+(t+1)+" yes");
            }else{
                System.out.println("#"+(t+1)+" no");
            }
        }
    }

    private static boolean isXOR(int[][] arr) {
        //0 ⊕ 0 = 0, 0 ⊕ 1 = 1, 1 ⊕ 0 = 1, 1 ⊕ 1 = 0
        int n = arr.length;
        int m = arr[0].length;
        boolean chk = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j && arr[i][j] == 0) {
                    chk = false;
                }
                else if (i != j && arr[i][j] == 1) {
                    chk = false;
                }
                else {
                    chk = true;
                }
            }
        }
        return chk;
    }
}
