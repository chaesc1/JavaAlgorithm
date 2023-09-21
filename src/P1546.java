import java.util.Arrays;
import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double arr[] = new double[sc.nextInt()]; //배열 크기 지정, double 형으로 생성

        for (int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        double sum = 0;
        Arrays.sort(arr); //정렬 수행 마지막 원소가 M
        double M = arr[arr.length-1];

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        System.out.println(sum/M*100/arr.length);
    }
}
