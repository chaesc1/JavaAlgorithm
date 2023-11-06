package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2806 {
    static int[] board;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine()); // num of queen, n * n board
            board = new int[N];
            answer = 0;

            countQueen(N, 0);
            System.out.println("#" + i + " " + answer);
        }
    }

    private static void countQueen(int n, int curr) {
        boolean isPossible;
        if (curr == n) {
            answer++;
            return;
        }
        //[curr][i] 에 놓을 수 있는지 체크
        for (int i = 0; i < n; i++) {
            isPossible = true;
            for (int j = 0; j < curr; j++) {
                if (board[j] == i || i == board[j] + (curr - j) || i == board[j] - (curr - j)) {        //직선, 대각선 확인
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                board[curr] = i;
                countQueen(n,curr+1);
            }
        }
    }
}
