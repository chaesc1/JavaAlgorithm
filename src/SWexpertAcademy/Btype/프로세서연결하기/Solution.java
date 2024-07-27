package SWexpertAcademy.Btype.프로세서연결하기;/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    static class Pos {
        int x,y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static ArrayList<Pos> list; // 연결가능한 cell 좌표 정보
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            // map 입력
            list = new ArrayList<>();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 셀이고 테두리 부분 아니면
                    if (i != 0 && i != N - 1 && j != 0 && j != N - 1 && map[i][j] == 1) {
                        list.add(new Pos(i, j));
                    }
                }
            }


        }
    }
}