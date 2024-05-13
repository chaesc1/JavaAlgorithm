package Book;

import java.util.ArrayList;

public class Prob43 {
    private static ArrayList<ArrayList<Integer>> answer;
    private static int n;

    private static void backTrack(int sum, ArrayList<Integer> selectedNum, int start) {
        if (sum == 10) {
            answer.add(selectedNum);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNum);
                list.add(i);
                backTrack(sum+i, list, i+1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        n = N;
        answer = new ArrayList<>();

        backTrack(0, new ArrayList<>(), 1);
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> solution = solution(5);
        System.out.println("solution = " + solution);
    }
}
