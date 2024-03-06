
import java.io.BufferedReader;
import java.io.InputStreamReader;

//55-50+40
//더하기 끼리 괄호로 묶어서 먼저 계산하고 빼기부분 계산함
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-");

        int res = 0;
        for (int i = 0; i < sub.length; i++) {
            int sum = 0;
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }
            if(i==0){
                res += sum;
            }else{
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
