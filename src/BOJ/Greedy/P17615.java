package BOJ.Greedy;
//볼 모으기
//바로 옆에 다른 색깔의 볼이 있으면 그 볼을 모두 뛰어 넘어 옮길 수 있다.
// 즉, 빨간색 볼은 옆에 있는 파란색 볼 무더기를 한 번에 뛰어 넘어 옮길 수 있다.
// 유사하게, 파란색 볼은 옆에 있는 빨간색 볼 무더기를 한 번에 뛰어 넘어 옮길 수 있다.

//옮길 수 있는 볼의 색깔은 한 가지이다.
//즉, 빨간색 볼을 처음에 옮겼으면 다음에도 빨간색 볼만 옮길 수 있다.
//유사하게, 파란색 볼을 처음에 옮겼으면 다음에도 파란색 볼만 옮길 수 있다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17615 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int red = 0;
        int blue = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == 'R'){
                red++;
            }else{
                blue++;
            }
        }

        //오른쪽으로 전부 R을 옮기는
        //BBBBRRRR
        for (int i = 0; i < n; i++) {

        }
        //완쪽으로 전부 R을 옮기는
        //RRRRBBBB

    }
}
