package Programmers.level2;

class SolutionP17687{
    public String numTok(int num,int n){
        StringBuilder sb = new StringBuilder();

        // 만약 진법 변환할 숫자가 진법보다 큰 경우
        while(num >= n) {
            sb.append(isMoreThanTen(num % n));
            num = num / n;
        }
        // 진법보다 작아진 수를 추가
        sb.append(isMoreThanTen(num));

        // 뒤집어서 리턴 - > 8을 2진법으로 위 로직을 돌리면 0001 됨
        return sb.reverse().toString();
    }

    private char isMoreThanTen(int i) {
        if(i >= 10){
            return (char) (i-10 + 'A');
        }
        return (char) (i+'0');
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;

        while (sb.length() < m*t){
            //num을 n 진수로 변환해서 sb에 append
            sb.append(numTok(num++,n));
        }
        System.out.println("sb = " + sb);
        for (int i = p-1; i < m*t; i+=m) {
            System.out.println("i = " + i);
            answer.append(sb.charAt(i));
        }

        return answer.toString();
    }

}
public class P17687 {
    public static void main(String[] args) {
        SolutionP17687 sol = new SolutionP17687();
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        System.out.println("sol.solution(16,16,2,1) = " + sol.solution(16,16,2,1));
    }
}
