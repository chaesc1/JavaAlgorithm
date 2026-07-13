package Inflearn.exhaustiveSearch;

import java.util.Arrays;

public class ex1 {
    public int[] solution(int[] a, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < a.length; i++) {
            for(int j=i+1; j<a.length; j++){
                if(a[i] + a[j] == target) {
                    return new int[]{a[i],a[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        ex1 solution = new ex1();
        System.out.println(Arrays.toString(solution.solution(new int[]{4, 9, 7, 5, 1}, 16)));
    }
}
