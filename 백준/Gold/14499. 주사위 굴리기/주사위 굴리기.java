import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dice = new int[7];
	static int N,M,x,y,K;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
		//0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir);
		}
	}
	
	private static void move(int dir) {
		int nx = x + dx[dir-1];
		int ny = y + dy[dir-1];
		
		if(nx < 0 || nx >= M || ny < 0 || ny >=N) return;
		
		game(dir,nx,ny);
		x = nx;
		y = ny;
	}
	// 1:동 2:서 3:북 4:남
	private static void game(int dir,int x,int y) {
		int tmp = dice[3];
		switch(dir) {
		case 1:
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 2:
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4:
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		
		if (map[y][x] == 0) {
			// 칸에다가 주사위 아랫면 복사
			map[y][x] = dice[6];
		} else {
			dice[6] = map[y][x];
			map[y][x] = 0;
		}
		
		System.out.println(dice[3]);
	}
}
