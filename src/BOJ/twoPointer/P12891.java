package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] checkCnt = new int[4];
        int[] Alpha = new int[26];
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        String dna = st.nextToken();
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            // A C G T 개수
            checkCnt[i] = Integer.parseInt(st.nextToken());
        }

    }
}
