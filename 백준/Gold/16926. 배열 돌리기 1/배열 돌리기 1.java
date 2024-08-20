import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R, Inner;
	static int[][] board, newBoard;
	static int[] rot, round;
	
	static void solution(int ptN, int ptM, int x, int y, int start, int value) {
		
		int cnt = 0;
		while(cnt < rot[start - 1]) {
			if (x < ptN && y == start) {
				x++;
			} else if (x == ptN && y < ptM) {
				y++;
			} else if (x > start && y == ptM) {
				x--;
			} else if (x == start && y > start) {
				y--;
			}
			cnt++;
		}
		newBoard[x][y] = value;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Inner = Math.min(N, M) / 2;  // Inner 계산 시 N과 M 중 작은 값을 기준으로 함
		rot = new int[Inner];
		round = new int[Inner];
		
		board = new int[N + 1][M + 1];
		newBoard = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int copyN = N;
		int copyM = M;
		for(int i = 0; i < Inner; i++) {
			if(i > 0) {
				copyN -= 2;
				copyM -= 2;
			}
			round[i] = 2 * (copyN - 1) + 2 * (copyM - 1); // 계산 착오 수정
			rot[i] = R % round[i];
		}
		copyN = N;
		copyM = M;
		for(int i = 1; i <= Inner; i++) {
			int x = i;
			int y = i;
			int cnt = 0;
			while(cnt < round[i - 1]) {
				if (x < copyN && y == i) {
					solution(copyN, copyM, x, y, i, board[x][y]);
					x++;
				} else if (x == copyN && y < copyM) {
					solution(copyN, copyM, x, y, i, board[x][y]);
					y++;
				} else if (x > i && y == copyM) {
					solution(copyN, copyM, x, y, i, board[x][y]);
					x--;
				} else if (x == i && y > i) {
					solution(copyN, copyM, x, y, i, board[x][y]);
					y--;
				}
				cnt++;
			}
			copyN--;
			copyM--;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				sb.append(newBoard[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}