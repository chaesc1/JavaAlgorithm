package SWexpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1221 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = {
                "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
        };
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine()," ");
            String num = st.nextToken();
            int length = Integer.parseInt(st.nextToken());

            int[] counting = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length; i++) {
                counting[map.get(st.nextToken())]++;
            }
            

            sb.append("#"+t).append("\n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < counting[i]; j++) {
                    sb.append(nums[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
