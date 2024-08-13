import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int W; //보호 필름 폭 W
	static int D; //보호필름 두께 D
	static int K; //합격기준 K
	static int Min; //최소 투약 횟수
	static int[][] film; //필름 정보
	static int[] chemicals;// 약품 투약 정보
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			Min = Integer.MAX_VALUE;
			chemicals = new int[D];
			
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W;j++) {
					film[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//------------Input End------------------------
			
			dfs(0,0); //약품투여 부분 집합 만들기
			
			System.out.println("#"+tc+" "+Min);
			
		}

	}
	/**
	 * dfs로 부분집합
	 * @param inputCnt : 약품 투여 횟수
	 * @param row : 약품 주입여부가 적용 될 행
	 */
	static void dfs(int inputCnt, int row) {
		if(inputCnt>K) { //약품 투여 횟수는 K개 이상일 필요 없음
			return;
		}
		//투여 횟수가 이미 저장된 최소 횟수를 넘어가면 return
		if(inputCnt>=Min) {
			return;
		}
		//두께 D 만큼 모두 약품을 투여했으면,
		if(row==D) {
			if(check()) { //합격 여부 검증
				// 최소값 갱신
				Min=Math.min(Min, inputCnt);
			}
			return;
		}
		
		
		//각 행 약품 투입 결정하기 - 부분 집합 만들기
		//각 행을 어떻게 처리할건지 결정해야 하기 때문에 경우의 수는 3가지
		// : 투입 안하는 경우 -1, A 약품 0, B 약품 1
		for(int i = -1;i<2;i++) {
			chemicals[row]=i; //결정한 내용 반영
			//약품 주입을 안하는 경우
			if(i==-1) {
				dfs(inputCnt, row+1);
			}else{ //약품 주입 처리하는 경우 
				dfs(inputCnt+1, row+1);
			}
		}
		//반복 되니까 for문으로 묶기
//		chemicals[row]=-1; //투입 안하는 경우
//		dfs(inputCnt, row+1);
//		chemicals[row]=0; //약품 0
//		dfs(inputCnt+1, row+1);
//		chemicals[row]=1; //약품 1
//		dfs(inputCnt+1, row+1);
		
	}
	
	
	/**
	 * 필름 합격 기준 통과 여부 확인을 위한 메소드
	 * @return true : 합격/ false : 불합격
	 */
	static boolean check() {
		int cnt = 0;
		int cur, next;
		for(int col=0; col<W; col++) { //열
			cnt = 1;
			for(int row = 0; row<D-1;row++) { //행
				//약품 투여정보를 가진 배열 확인하면서 약품 투여 여부 확인. 
				//투여 안했으면 원본 배열 값 가져오기. 투여 했으면 약품 투여 정보 배열에서 가져오기
				cur=chemicals[row] == -1? film[row][col]: chemicals[row];
				//연속성 확인을 위해 다음 row 확인
				next = chemicals[row+1] ==-1? film[row+1][col] : chemicals[row+1];
				
				if(cur==next) { //지금과 다음이 같으면, 
					cnt++; //연속 숫자 증가
					if(cnt>=K) {//합격 기준 넘은 경우 더 확인할 필요 없음
						break;
					}
				}else {//합격기준 되기 전에 다르면 1로 초기화
					cnt=1;
				}
			}
			if(cnt<K) { //최종 구해진 cnt가 합격기준보다 작으면 탈락 return false
				return false;
			}
		}
		return true; //통과 했으면 true
	}

}