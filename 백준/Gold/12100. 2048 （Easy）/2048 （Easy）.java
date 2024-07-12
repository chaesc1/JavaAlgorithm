import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n,answer;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		start(0);
		System.out.println(answer);
	}
	
	private static void start(int depth) {
		if(depth == 5) {
			find();
			return;
		}
		
		// 복사해
		int[][] copy = new int[n][n];
		for(int i=0; i<n; i++) 
			copy[i] = board[i].clone();
		
		//게임 시작 depth + 1
		for(int dir=0; dir<4; dir++) {
			move(dir);
			start(depth+1);
			//다시 원래 보드로 변경
			for(int i=0; i<n; i++) {
				board[i] = copy[i].clone();
			}
		}
	}
	
	private static void move(int dir) {
		switch (dir) {
		// 상 하 좌 우
		case 0:
			for (int i=0; i<n; i++) {
				int num = 0;
				int index = 0;
				for(int j=0; j<n; j++) {
					if(board[j][i] != 0) {
						// 같은 수가 있다면 
						if(num == board[j][i]) {
							board[index-1][i] = num * 2;
							num = 0;
							board[j][i] = 0;
						} else {
							num = board[j][i];
							board[j][i] = 0;
							board[index][i] = num;
							index++;
						}
					}
				}
			}
			break;
		case 1:
			for (int i=0; i<n; i++) {
				int num = 0;
				int index = n-1;
				for(int j=n-1; j>=0; j--) {
					if(board[j][i] != 0) {
						// 같은 수가 있다면 
						if(num == board[j][i]) {
							board[index+1][i] = num * 2;
							num = 0;
							board[j][i] = 0;
						} else {
							num = board[j][i];
							board[j][i] = 0;
							board[index][i] = num;
							index--;
						}
					}
				}
			}
			break;
		case 2:
			for (int i=0; i<n; i++) {
				int num = 0;
				int index = 0;
				for(int j=0; j<n; j++) {
					if(board[i][j] != 0) {
						// 같은 수가 있다면 
						if(num == board[i][j]) {
							board[i][index-1] = num * 2;
							num = 0;
							board[i][j] = 0;
						} else {
							num = board[i][j];
							board[i][j] = 0;
							board[i][index] = num;
							index++;
						}
					}
				}
			}
			break;
		case 3:
			for (int i=0; i<n; i++) {
				int num = 0;
				int index = n-1;
				for(int j=n-1; j>=0; j--) {
					if(board[i][j] != 0) {
						// 같은 수가 있다면 
						if(num == board[i][j]) {
							board[i][index+1] = num * 2;
							num = 0;
							board[i][j] = 0;
						} else {
							num = board[i][j];
							board[i][j] = 0;
							board[i][index] = num;
							index--;
						}
					}
				}
			}
			break;
		}
	}
	private static void find() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				answer = Math.max(answer, board[i][j]);
	}
}
