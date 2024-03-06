//투 포인터 문제
// 수들의 합 5 - 실버 5
//투 포인터는 슬라이딩 윈도우라고 함
//N 값이 커서 완전탐색방식을 사용할때 시간초과 -> 투포인터 사용
//1차원 배열이 있고 . 배열 안에서 각자 다른 원소를 가리키고 있는 2개의 포인터를 설정
//2개의 포인터를 조작하면서 원하는 값을 얻음

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 1;

        int start = 1,end = 1,sum = 1;
        //sum > N : sum -= start; start++
        //sum < N : sum += end; end++
        while(end!=N){
            if(sum==N){
                answer++;
                end++;
                sum+=end;
            }else if(sum>N){
                sum -= start;
                start++;
            }else{
                end++;
                sum+=end;
            }
        }
        System.out.println(answer);
    }
}
