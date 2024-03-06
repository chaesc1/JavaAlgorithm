
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        int start = 0;
        int end = n-1;

        while (start < end){
            if (arr[start] + arr[end] == m) {
                answer++;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] > m){
                end--;
            }
            else{
                start++;
            }
        }
        System.out.println(answer);
    }
}
