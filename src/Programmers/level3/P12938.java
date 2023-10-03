package Programmers.level3;

//자연수 n 개로 이루어진 중복 집합(multi set, 편의상 이후에는 "집합"으로 통칭) 중에 다음 두 조건을 만족하는 집합을 최고의 집합이라고 합니다.
//
//각 원소의 합이 S가 되는 수의 집합
//위 조건을 만족하면서 각 원소의 곱 이 최대가 되는 집합

import java.util.PriorityQueue;

//예를 들어서 자연수 2개로 이루어진 집합 중 합이 9가 되는 집합은 다음과 같이 4개가 있습니다.
//{ 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }
//그중 각 원소의 곱이 최대인 { 4, 5 }가 최고의 집합입니다.
//
//집합의 원소의 개수 n과 모든 원소들의 합 s가 매개변수로 주어질 때, 최고의 집합을 return 하는 solution 함수를 완성해주세요.
class Solution12938 {
    //어떻게 하면 곱이 최대가 될까를 생각 해보자 .
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        //나눠 떨어지는 경우
        if(s%n==0){
            for (int i = 0; i < n; i++) {
                answer[i] = s/n;
            }
        }else{
            int cnt = s%n; //3 3 3 에서 s가 10일 경우 3 3 4 즉 10%3 -> 1개를 바꿔야해
            int changeIdx = n - cnt;//바꿔줘야할 첫 인덱스
            for(int i = 0; i<changeIdx; i++){
                answer[i] = s/n;
            }
            for(int i=changeIdx; i<n; i++){
                answer[i] = s/n + 1;
            }
        }
        return answer;
    }
}
public class P12938 {
    public static void main(String[] args) {
        Solution12938 sol = new Solution12938();
        int n = 2, s= 9;
        int[] result = sol.solution(n, s);
        if (result.length == 1 && result[0] == -1) {
            System.out.println("최고의 집합이 없습니다.");
        } else {
            System.out.print("최고의 집합: ");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
