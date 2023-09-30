package BOJ.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

//절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
//
//        배열에 정수 x (x ≠ 0)를 넣는다.
//        배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
//프로그램은 처음에 비어있는 배열에서 시작하게 된다.
public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absX = Math.abs(o1);
            int absY = Math.abs(o2);

            if(absX == absY){//같을경우 음수인 수가 우선
                if(o1 > o2){
                    return 1;
                }
                else{
                    return -1;
                }
        }
        return absX-absY;//절댓값이 작은값이 우선
        });

        for (int i = 0; i < N; i++) {
            int req = Integer.parseInt(bf.readLine());
            if(req == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }
            }else {
                pq.add(req);
            }
        }
    }
}
