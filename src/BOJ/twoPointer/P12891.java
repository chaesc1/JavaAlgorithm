package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P12891 {
    static int[] checkCnt = new int[4];
    static int[] myArr = new int[4];
    static char[] dna;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        dna = bf.readLine().toCharArray();//DNA 입력받고
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            // A C G T 개수
            checkCnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) { //첫번째 부분문자열 0 ~ p-1까지
            if(dna[i] == 'A') myArr[0]++;
            if(dna[i] == 'C') myArr[1]++;
            if(dna[i] == 'G') myArr[2]++;
            if(dna[i] == 'T') myArr[3]++;
        }

        if(isTrue()) answer++;
//        for (int i = 0; i < 4; i++) {
//            System.out.println(myArr[i]);
//        }
        //다음 문자열 -> 첫번째 문자는 제거하고 뒤에 한 문자를  추가한 뒤에 isTrue 실행
        int i = -1;
        for (int j = p; j < s; j++) {
            i = j-p;

            if(dna[i] == 'A') myArr[0]--;
            if(dna[i] == 'C') myArr[1]--;
            if(dna[i] == 'G') myArr[2]--;
            if(dna[i] == 'T') myArr[3]--;

            if(dna[j] == 'A') myArr[0]++;
            if(dna[j] == 'C') myArr[1]++;
            if(dna[j] == 'G') myArr[2]++;
            if(dna[j] == 'T') myArr[3]++;

            if(isTrue()) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isTrue() {
        for (int i = 0; i < 4; i++) {
            if(checkCnt[i] > myArr[i]) return false;
        }
        return true;
    }
}
