import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int s,p,ans;
	static char[] dna;
	static int minA,minC,minG,minT;//최소로 들어있어야할 값
	static int cntA,cntC,cntG,cntT;//실제로 부분문자열에 카운트 되어야 할 값
	
	private static void check() {
		if(minA <= cntA && minC <= cntC && minG <= cntG && minT <= cntT) {
			ans++;
		}
	}
	
	private static void solve() {
		for(int i=0; i<p; i++) {
			switch (dna[i]) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
				
			}
		}
		check();//최소 문자수 체크하고
		//슬라이딩 윈도우 수행
		for(int i=p; i<s; i++) {
			switch (dna[i-p]) {
			case 'A':
				cntA--;
				break;
			case 'C':
				cntC--;
				break;
			case 'G':
				cntG--;
				break;
			case 'T':
				cntT--;
				break;
				
			}
			switch (dna[i]) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
				
			}
			
			check();
		}
	}
	
	
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		
		//DNA 입력 
		dna = new char[s];
		dna = bf.readLine().toCharArray();
		
		//만족해야할 최소 갯수
		st = new StringTokenizer(bf.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());
		
		solve();
		System.out.println(ans);
 	}
}
 