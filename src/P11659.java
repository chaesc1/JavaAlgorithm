import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
// 받는 데이터의 양이 많을 경우는
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int num = Integer.parseInt(stringTokenizer.nextToken());
        int size = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bf.readLine());

        //합 배열 생성
        long[] sum = new long[num + 1];
        for(int i=1; i<=num; i++){
            sum[i] = sum[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int k=0; k<size; k++){
            stringTokenizer = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sum[j]-sum[i-1]);
        }
    }
}
