import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int first = 666;
        int count = 1;
        while(count != n) {
            first++;

            if(String.valueOf(first).contains("666")) {
                count++;
            }
        }

        System.out.println(first);
    }
}