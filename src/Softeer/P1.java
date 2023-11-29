package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2
//4 farmer fox goose beans / n명  n개이름
//1 farmer / 배를 몰아야하는 사람 또는 사물
//3 / 강둑에 넘겨ㅛ지면 안되는 조합의 개수 B
//2 fox goose / 강둑에 남겨지면 안되는 조합
//2 goose beans /
//3 fox goose beans / 배에 함께 타면 안되는 조합의 개수,R
//0

public class P1 {
    static String[] left;
    static String[] right;

    static int[] boat;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //배의크기
        boat = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken()); // 명수
        left = new String[len]; // 강 반대편
        for (int i = 0; i < len; i++) {
            left[i] = st.nextToken();
        }
    }
}
//2
//        4 farmer fox goose beans
//        1 farmer
//        3
//        2 fox goose
//        2 goose beans
//        3 fox goose beans
//        0