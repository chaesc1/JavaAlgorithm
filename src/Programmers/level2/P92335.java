package Programmers.level2;

import java.security.spec.RSAOtherPrimeInfo;

class Solution92335{
    //소수 구하는 로직
    public boolean isPrime(long num){
        if(num<=1) return false;
        else if(num == 2) return true;
        else{//에라토스테네스의 채
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public String numToString(int num,int k){
        String s = "";
        while (num > 0){
            s = num % k + s; //조심해야 할 것은 나눈 나머지를 역으로 붙여야한다.
            num /= k;
        }
        return s;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String str = numToString(n,k);
        String[] arr = str.split("0");
        
        for(String s: arr){
            if(s.equals("")) continue;
            long num = Long.parseLong(s);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
}
public class P92335 {
    public static void main(String[] args) {
        Solution92335 sol = new Solution92335();
        System.out.println(sol.solution(437674,3));
    }
}
