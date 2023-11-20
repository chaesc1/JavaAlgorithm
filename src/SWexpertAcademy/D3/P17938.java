package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//세 개의 자연수 X,Y,Z가 주어질 때, 다음 조건을 모두 만족시키는 세 개의 문자열 A,B,C를 아무거나 하나 구하는 프로그램을 작성하라.
//-   A,B,C는 모두 ‘0’ 또는 ‘1’로만 구성된 길이가 1 이상 1,000 이하인 문자열이다.
//-    LCS(A, B) = X
//-    LCS(B, C) = Y
//-    LCS(C, A) = Z
//  조건을 만족하는 세 문자열이 항상 존재함을 증명
public class P17938 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

        }
    }
}
