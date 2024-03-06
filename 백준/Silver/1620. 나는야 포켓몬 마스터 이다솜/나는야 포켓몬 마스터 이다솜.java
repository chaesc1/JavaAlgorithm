import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> poke1 = new HashMap<>();
        HashMap<String ,Integer> poke2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String S = br.readLine();
            poke1.put(i,S);
            poke2.put(S,i);
        }
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            //첫글자를 아스키코드로 1~9 인지 판별 -> 정수
            if(input.charAt(0) >= 49 && input.charAt(0) <= 57) {
                System.out.println(poke1.get(Integer.parseInt(input)));
            }else {
                System.out.println(poke2.get(input));
            }
        }
    }
}
