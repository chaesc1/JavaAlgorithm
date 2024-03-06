import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken()); //목표가 되는 숫자

        int cnt = 1;
        while (A!=target){
            if(target < A){
                System.out.println(-1);
                return;
            }

            if(target % 2 == 0){
                target /= 2;
            }else if(target % 10 == 1){
                target /= 10;
            }else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
